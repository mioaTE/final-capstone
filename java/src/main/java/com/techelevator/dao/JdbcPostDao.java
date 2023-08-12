package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Post;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcPostDao implements  PostDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Post getPostByPostId(int postId){
        Post post = null;
        String sql = "SELECT "; //TODO add sql
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

    private Post mapRowToPost(SqlRowSet rs) {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setLikesCount(rs.getInt("post_likes"));
        post.setPostDescription(rs.getString("post_description"));
        post.setUrlImage(rs.getString("post_img"));

        return post;
    }
}
