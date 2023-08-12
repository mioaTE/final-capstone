package com.techelevator.dao;

import com.techelevator.model.Post;

import java.util.List;

public interface PostDao {

    Post getPostByPostId(int postId);

    Post createPost(Post post);

    List<Post> getPost();
}
