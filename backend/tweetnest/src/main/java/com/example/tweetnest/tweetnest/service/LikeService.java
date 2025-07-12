package com.example.tweetnest.tweetnest.service;

import com.example.tweetnest.tweetnest.exception.TweetException;
import com.example.tweetnest.tweetnest.exception.UserException;
import com.example.tweetnest.tweetnest.model.Like;
import com.example.tweetnest.tweetnest.model.User;

import java.util.List;

public interface LikeService {

    // Tweet ko like karne ke liye ye method hai. jab bhi user like pe click karega toh woh like ho jaayega and phirse click kiya toh unlike kar dega
    public Like likeTweet(Long tweetId, User user) throws UserException, TweetException;
    // List of likes chahiye. kisi particular tweet ki id pass karun aur mujhe all the likes mil jaani chahiye.
    public List<Like> getAllLikes(Long tweetId) throws TweetException;

}
