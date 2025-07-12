package com.example.tweetnest.tweetnest.service;

import com.example.tweetnest.tweetnest.exception.TweetException;
import com.example.tweetnest.tweetnest.exception.UserException;
import com.example.tweetnest.tweetnest.model.Tweet;
import com.example.tweetnest.tweetnest.model.User;
import com.example.tweetnest.tweetnest.request.TweetReplyRequest;

import java.util.List;

public interface TweetService {

    // Request legi tweet ka and user as a parameter(kaunsa user tweet kar raha hai isiliye) and throw userexcception
    public Tweet createTweet(Tweet req, User user) throws UserException;

    // for getting all tweets
    public List<Tweet> findAllTweets();

    // kis tweet ko main retweet karna chahta hoon isiliye tweetId chahiye aur kaunsa user isko retweet karna chahta hai
    // Tweet exception bhi aayega kyunki main tweet id dena wala hoon , aur agar tweet exists nahi hai toh it will throw exception
    public Tweet retweet(Long tweetId,User user) throws UserException, TweetException;

    // jo tweetId diya hoon it should exists otherwise will throw Tweetexception
    public Tweet findById(Long tweetId) throws TweetException;

    // Kausa user ne tweet ko delete kiya isilye userId, and also give the tweetId to delete tweet.
    // jo tweetId and userId diya hoon it should exists otherwise will throw Tweetexception
    public void deleteTweetById(Long tweetId,Long userId) throws TweetException, UserException;

    // agar kisi user ne retweet kia hai uske baad woh unretweet bhi kar sakta hai.
    //kis tweet ko user unretweet karna chahta hai,and the User user diya hai woh kaunsa user retweet karna chahta hai
    public Tweet removeFromRetweet(Long tweetId,User user) throws TweetException,UserException;

    // kausi tweet ke liye hamara reply create karna chahta hai, woh tweet bhi exists karni chahiye
    public Tweet createdReply(TweetReplyRequest request, User user) throws TweetException;

    // 1. kisi particular user ki tweet find karne ke liye.
    // 2. ye bhi list of tweet rahega as a return, jis bhi user ki id pe hum click karte hai. user ki profile pe,
    // us user ne jitne bhi tweet create ki hogi woh saari tweet hame mil jaayegi
    public List<Tweet> getUserTweet(User user);

    // User ne jitne bhi tweet like ki hai woh sab yahan milegi
    public List<Tweet> findByLikesContainsUser(User user);

}
