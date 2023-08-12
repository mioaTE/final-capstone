package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Post;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcPostDao implements PostDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPostDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Post getPostByPostId(int postId){
        Post post = null;
        String sql = "SELECT post_id, user_id, post_description, post_img, post_likes, created_on FROM post WHERE post_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId);
            if(results.next()){
                post = mapRowToPost(results);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return post;
    }

    @Override
    public Post createPost(Post post){
        Post newPost = null;
        String sql = "INSERT INTO post ( post_id, user_id, post_description, post_img, post_likes, created_on) VALUES ( ?, ?, ?, ?, ?, ?) RETURNING post_id";
        try{
            int newPostId = jdbcTemplate.queryForObject(sql, int.class, post.getPostId(), post.getUserId(), post.getPostDescription(), post.getUrlImage(), post.getLikesCount(), post.getPostCreateTime());
            newPost = getPostByPostId(newPostId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newPost;
    }

    @Override
    public List<Post> getPost(){
        List<Post> allPost = new ArrayList<>();
        Post post = null;
        String sql = "SELECT post_id, user_id, post_description, post_img, post_likes, created_on FROM post";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            if(results.next()){
                post = mapRowToPost(results);
                allPost.add(post);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return allPost;
    }
    private Post mapRowToPost(SqlRowSet rs) {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setUserId(rs.getInt("user_id"));
        post.setPostDescription(rs.getString("post_description"));
        post.setUrlImage(rs.getString("post_img"));
        post.setLikesCount(rs.getInt("post_likes"));
        post.setPostCreateTime(rs.getTime("created_on"));

        return post;
    }
}
