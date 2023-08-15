package com.techelevator.dao;

import com.techelevator.model.Comment;
import java.util.List;

public interface CommentDao {

    Comment getCommentById(int commentId);

    List<Comment> listCommentsByPost(int postId);

    Comment submitComment(Comment comment);

    int deleteComment(int commentId);
}