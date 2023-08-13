package com.techelevator.dao;

import com.techelevator.model.Comment;
import java.util.List;

public interface CommentDao {

    Comment getComment(int commentId);

    List<Comment> listComments(int postId);

    void submitComment(int userId, Comment comment);

    void deleteComment(int userId, int commentId);
}