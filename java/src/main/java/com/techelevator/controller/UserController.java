package com.techelevator.controller;

import com.techelevator.dao.FavoriteDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Favorite;
import com.techelevator.model.Like;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private UserDao userDao;
    private FavoriteDao favoriteDao;

    public UserController(UserDao userDao, FavoriteDao favoriteDao) {
        this.userDao = userDao;
        this.favoriteDao = favoriteDao;
    }

    @CrossOrigin
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") int id) {
        User user = userDao.getUserById(id);
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found.");
        } else {
            return user;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/favorites", method = RequestMethod.POST)
    public void addFavorite(@Valid @RequestBody Favorite newFavorite) {
        try {
            favoriteDao.createFavorite(newFavorite);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Favorite creation failed.");
        }
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/favorite/{userId}/{postId}", method = RequestMethod.DELETE)
    public void deleteFavorite(@PathVariable int userId, @PathVariable int postId) {
        try {
            favoriteDao.deleteFavorite(userId, postId);
        }  catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Favorite deletion failed.");
        }
    }

    @CrossOrigin
    @RequestMapping (path = "/all-favorites/{userId}", method = RequestMethod.GET)
    public List<Favorite> getAllLikesByUserId(@PathVariable int userId) {
        return favoriteDao.getAllFavoritesByUserId(userId);
    }

}
