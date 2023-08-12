package com.techelevator.controller;


import com.techelevator.dao.JdbcPostDao;
import com.techelevator.dao.PostDao;


import com.techelevator.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    private PostDao postDao;


    public PostController (PostDao postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPost() {
        return postDao.getPost();
    }


    @RequestMapping(path = "/posts/user/{Id}", method = RequestMethod.GET)
    public List<Post> getUsersPost(@PathVariable int Id) {
        return postDao.getPostByUserId(Id);
    }

    @RequestMapping(path = "/posts/{Id}", method = RequestMethod.GET)
    public Post getPostById(@PathVariable int Id) {
        return postDao.getPostByPostId(Id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/posts", method = RequestMethod.POST)
    public Post addPost(@Valid @RequestBody Post post) {
        return postDao.createPost(post);
    }

}
