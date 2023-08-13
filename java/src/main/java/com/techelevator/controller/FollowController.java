//package com.techelevator.controller;
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