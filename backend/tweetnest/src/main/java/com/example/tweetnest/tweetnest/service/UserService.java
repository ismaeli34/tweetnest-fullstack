package com.example.tweetnest.tweetnest.service;

import com.example.tweetnest.tweetnest.exception.UserException;
import com.example.tweetnest.tweetnest.model.User;

import java.util.List;

public interface UserService {

    // userId lega aur mujhe User return karega.
    public User findUserById(Long userId) throws UserException;

    //
    public User findUserProfileByJwt(String jwt) throws UserException;

    // user ko update karne ke liye updated user return karega.
    // jis user ko main update karna chahta hoon uska id dena hai
    public User updateUser(Long userId, User user) throws UserException;

    // user ko follow and unfollow karne ke liye.
    public User followUser(Long userId, User user) throws UserException;

    // user ko search karne ke liye and it will return list of users
    public List<User> searchUser(String query);

}
