package com.techelevator.controller;


import com.techelevator.dao.PostDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.LoginDto;
import com.techelevator.model.LoginResponseDto;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import com.techelevator.security.jwt.JWTFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    private PostDao postDao;


    public PostController (PostDao postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(path = "/post", method = RequestMethod.GET)
    public List<Post> getAllPost() {
        return postDao.getPost();
    }


}
