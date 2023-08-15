package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Comment;
import com.techelevator.model.Post;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCommentDao implements CommentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comment getCommentById(int commentId) {
        Comment comment = null;
        String sql = "SELECT comment_id, user_id, post_id, comment FROM comments WHERE comment_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, commentId);
            if(results.next()){
                comment = mapRowToComment(results);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return comment;
    }

    @Override
    public List<Comment> listCommentsByPost(int postId) {
        List<Comment> commentList = new ArrayList<>();
        Comment comment = null;
        String sql = "SELECT comment_id, user_id, post_id, comment FROM comments WHERE post_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId);

            while (results.next()) {
                comment = mapRowToComment(results);
                commentList.add(comment);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return commentList;
    }


    @Override
    public Comment submitComment(Comment comment) {
        Comment newComment = null;
        String sql = "INSERT INTO comments (user_id, post_id, comment) " +
                "VALUES (?,?,?) RETURNING comment_id;";
        try {
            int newCommentId = jdbcTemplate.queryForObject(sql, int.class, comment.getUserId(), comment.getPostId(), comment.getComment());
            newComment = getCommentById(newCommentId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newComment;
    }
    @Override
    public int deleteComment(int commentId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM comments WHERE comment_id = ?";
        try {
            jdbcTemplate.update(sql, commentId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }

    private Comment mapRowToComment(SqlRowSet results) {
        Comment theComment = new Comment();
        theComment.setCommentId(results.getInt("comment_id"));
        theComment.setUserId(results.getInt("user_id"));
        theComment.setPostId(results.getInt("post_id"));
        theComment.setComment(results.getString("comment"));

        return theComment;
    }
}