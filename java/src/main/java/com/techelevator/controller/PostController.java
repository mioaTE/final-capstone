package com.techelevator.controller;


import com.techelevator.dao.JdbcPostDao;
import com.techelevator.dao.LikeDao;
import com.techelevator.dao.PostDao;


import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
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


    public PostController (PostDao postDao, UserDao userDao, LikeDao likeDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.likeDao = likeDao;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPost() {
        return postDao.getPost();
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }


    @RequestMapping(path = "/posts/user/{Id}", method = RequestMethod.GET)
    public List<Post> getUsersPost(@PathVariable int Id) {
        return postDao.getPostByUserId(Id);
    }

    @RequestMapping(path = "/posts/{Id}", method = RequestMethod.GET)
    public Post getPostById(@PathVariable int Id) {
        return postDao.getPostByPostId(Id);
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

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/likes", method = RequestMethod.POST)
    public void addLike(@Valid @RequestBody Like newLike) {
        try {
            likeDao.createLike(newLike);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Like creation failed.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/liked", method = RequestMethod.DELETE)
    public void delete(@RequestBody Like newLike) {
        try {
            likeDao.deleteLike(newLike);
        }  catch (DaoException e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Like deletion failed.");
        }
    }

}
