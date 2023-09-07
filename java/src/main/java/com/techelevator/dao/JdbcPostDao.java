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
    public Post updatePostLikes(Post post) {
        Post updatedPost = null;
        String sql = "UPDATE post SET post_likes = (SELECT COUNT(post_id) FROM likes WHERE post.post_id = likes.post_id) WHERE post_id = ?;";

        try {
            jdbcTemplate.update(sql, post.getPostId());
            updatedPost = getPostByPostId(post.getPostId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return updatedPost;
    }

    @Override
    public List<Post> getPostByUserId(int userId){
        List<Post> usersPost = new ArrayList<>();
        Post post = null;
        String sql = "SELECT post_id, user_id, post_description, post_img, post_likes, created_on FROM post WHERE user_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while(results.next()){
                post = mapRowToPost(results);
                usersPost.add(post);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return usersPost;
    }

    @Override
    public Post createPost(Post post){
        Post newPost = null;
        String sql = "INSERT INTO post ( user_id, post_description, post_img, post_likes, created_on) VALUES ( ?, ?, ?, ?, ?) RETURNING post_id";
        try{
            int newPostId = jdbcTemplate.queryForObject(sql, int.class, post.getUserId(), post.getPostDescription(), post.getUrlImage(), post.getLikesCount(), post.getPostCreateTime());
            //jdbcTemplate is for talk to the database
            //queryFor Object is inserting and retrieving the return object(postId)
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
        String sql = "SELECT post_id, user_id, post_description, post_img, post_likes, created_on FROM post ORDER BY post_id DESC";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
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
