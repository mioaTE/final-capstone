package com.techelevator.controller;


import com.techelevator.dao.JdbcPostDao;
import com.techelevator.dao.PostDao;


import com.techelevator.model.Post;
import org.springframework.web.bind.annotation.*;

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


}
