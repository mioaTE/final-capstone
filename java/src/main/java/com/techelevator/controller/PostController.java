package com.techelevator.controller;


import com.techelevator.dao.JdbcPostDao;
import com.techelevator.dao.LikeDao;
import com.techelevator.dao.PostDao;

import com.techelevator.dao.UserDao;


import com.techelevator.dao.*;



import com.techelevator.exception.DaoException;
import com.techelevator.model.Comment;
import com.techelevator.model.Like;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    private PostDao postDao;
    private UserDao userDao;
    private LikeDao likeDao;

    private CommentDao commentDao;




    public PostController (PostDao postDao, UserDao userDao, LikeDao likeDao, CommentDao commentDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.likeDao = likeDao;
        this.commentDao = commentDao;
    }


    @CrossOrigin
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPost() {
        return postDao.getPost();
    }
    @CrossOrigin
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }
    @CrossOrigin
    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userDao.getUserById(id);
    }

    @CrossOrigin
    @RequestMapping(path = "/posts/user/{Id}", method = RequestMethod.GET)
    public List<Post> getUsersPost(@PathVariable int Id) {
        return postDao.getPostByUserId(Id);
    }
    @CrossOrigin
    @RequestMapping(path = "/posts/{Id}", method = RequestMethod.GET)
    public Post getPostById(@PathVariable int Id) {
        return postDao.getPostByPostId(Id);
    }

    @CrossOrigin
    @RequestMapping(path = "/posts/{Id}", method = RequestMethod.PUT)
    public Post updatePost(@PathVariable int Id, @RequestBody Post post) {
        post.setPostId(Id);
        try {
            Post updatedPost = postDao.updatePostLikes(post);
            return updatedPost;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }
    }

    @CrossOrigin
    @RequestMapping (path = "/all-likes", method = RequestMethod.GET)
    public List<Like> getAllLikes() {
        return likeDao.getAllLikes();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/posts", method = RequestMethod.POST)
    public void addPost(@Valid @RequestBody Post newPost) {
        try {
            Post post = postDao.createPost(newPost);
            if (post == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post creation failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Post creation failed.");
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/comments", method = RequestMethod.POST)
    public void addComment(@Valid @RequestBody Comment newComment) {
        try {
            Comment comment = commentDao.submitComment(newComment);
            if(comment == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment creation failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Comment creation failed.");
        }

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/likes", method = RequestMethod.POST)
    public void addLike(@Valid @RequestBody Like newLike) {
        try {
            likeDao.createLike(newLike);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Like creation failed.");
        }
    }
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/like/{userId}/{postId}", method = RequestMethod.DELETE)
    public void deleteLike(@PathVariable int userId, @PathVariable int postId) {
        try {
            likeDao.deleteLike(userId, postId);
        }  catch (DaoException e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Like deletion failed.");
        }
    }
}