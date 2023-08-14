package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.techelevator.dao.*;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

//@RestController
//@CrossOrigin(origins="*")
//@PreAuthorize("isAuthenticated()")
//
//public class FollowController {
//    @Autowired
//    private UserDao userDAO;
//    @Autowired
//    private FollowDao followDAO;

    // follow another user  -- post
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(path = "/follow/{followedId}", method = RequestMethod.POST)
//    public void follow(@PathVariable int followedId, Principal principal) {
//        int followerId = userDAO.findIdByUsername(principal.getName());
//        followDAO.follow(followerId, followedId);
//    }

    // delete followed user
//    @RequestMapping(path = "/follow/{followedId}", method = RequestMethod.DELETE)
//    public void unfollow(@PathVariable int followedId, Principal principal) {
//        int followerId = userDAO.findIdByUsername(principal.getName());
//        followDAO.unfollow(followerId, followedId);
//    }

    // get list of followed users
//    @RequestMapping(path = "/follow", method = RequestMethod.GET)
//    public List<User> list(Principal principal) {
//        int userId = userDAO.findIdByUsername(principal.getName());
//        return followDAO.list(userId);
//    }
//}
//=======
//package com.techelevator.controller;
//import com.techelevator.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins="*")
//@PreAuthorize("isAuthenticated()")
//
//public class FollowController {
//    @Autowired
//    private UserDAO userDAO;
//    @Autowired
//    private FollowDAO followDAO;
//
//    // follow another user  -- post
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(path = "/follow/{followedId}", method = RequestMethod.POST)
//    public void follow(@PathVariable int followedId, Principal principal) {
//        int followerId = userDAO.findIdByUsername(principal.getName());
//        followDAO.follow(followerId, followedId);
//    }
//
//    // delete followed user
//    @RequestMapping(path = "/follow/{followedId}", method = RequestMethod.DELETE)
//    public void unfollow(@PathVariable int followedId, Principal principal) {
//        int followerId = userDAO.findIdByUsername(principal.getName());
//        followDAO.unfollow(followerId, followedId);
//    }
//
//    // get list of followed users
//    @RequestMapping(path = "/follow", method = RequestMethod.GET)
//    public List<User> list(Principal principal) {
//        int userId = userDAO.findIdByUsername(principal.getName());
//        return followDAO.list(userId);
//    }
//}
//>>>>>>> b1a4a8794c55c8fd7a1d20b32af3198710014b01