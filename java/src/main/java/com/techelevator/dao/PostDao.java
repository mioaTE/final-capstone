package com.techelevator.dao;

import com.techelevator.model.Post;

import java.util.List;

public interface PostDao {

    List<Post> getPostByUserId(int userId);

    Post getPostByPostId(int postId);

    Post createPost(Post post);

    List<Post> getPost();
}
