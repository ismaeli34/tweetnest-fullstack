package com.example.tweetnest.tweetnest.controller;

import com.example.tweetnest.tweetnest.dto.TweetDto;
import com.example.tweetnest.tweetnest.dto.mapper.TweetDtoMapper;
import com.example.tweetnest.tweetnest.exception.TweetException;
import com.example.tweetnest.tweetnest.exception.UserException;
import com.example.tweetnest.tweetnest.model.Tweet;
import com.example.tweetnest.tweetnest.model.User;
import com.example.tweetnest.tweetnest.request.TweetReplyRequest;
import com.example.tweetnest.tweetnest.response.ApiResponse;
import com.example.tweetnest.tweetnest.service.TweetService;
import com.example.tweetnest.tweetnest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    private ResponseEntity<TweetDto> createTweet(@RequestBody Tweet req, @RequestHeader("Authorization") String jwt) throws UserException, TweetException{
        User user = userService.findUserProfileByJwt(jwt);
        Tweet tweet = tweetService.createTweet(req,user);
        TweetDto tweetDto = TweetDtoMapper.toTweetDto(tweet,user);
        return new ResponseEntity<>(tweetDto, HttpStatus.CREATED);
    }

    @PostMapping("/reply")
    private ResponseEntity<TweetDto> replyTweet(@RequestBody TweetReplyRequest req, @RequestHeader("Authorization") String jwt) throws UserException, TweetException{
        User user = userService.findUserProfileByJwt(jwt);
        Tweet tweet = tweetService.createdReply(req,user);
        TweetDto tweetDto = TweetDtoMapper.toTweetDto(tweet,user);
        return new ResponseEntity<>(tweetDto, HttpStatus.CREATED);
    }


    @PutMapping("/{tweetId}/retweet")
    private ResponseEntity<TweetDto> retweet(@PathVariable Long tweetId, @RequestHeader("Authorization") String jwt) throws UserException, TweetException{
        User user = userService.findUserProfileByJwt(jwt);
        Tweet tweet = tweetService.retweet(tweetId,user);
        TweetDto tweetDto = TweetDtoMapper.toTweetDto(tweet,user);
        return new ResponseEntity<>(tweetDto, HttpStatus.OK);
    }


    @GetMapping("/{tweetId}")
    private ResponseEntity<TweetDto> findTweetbyId(@PathVariable Long tweetId, @RequestHeader("Authorization") String jwt) throws UserException, TweetException{
        User user = userService.findUserProfileByJwt(jwt);
        Tweet tweet = tweetService.retweet(tweetId,user);
        TweetDto tweetDto = TweetDtoMapper.toTweetDto(tweet,user);
        return new ResponseEntity<>(tweetDto, HttpStatus.OK);
    }

    @DeleteMapping("/{tweetId}")
    private ResponseEntity<ApiResponse> deleteTweet(@PathVariable Long tweetId,
                                                 @RequestHeader("Authorization") String jwt) throws UserException, TweetException{
        User user = userService.findUserProfileByJwt(jwt);
        tweetService.deleteTweetById(tweetId,user.getId());
         ApiResponse response = new ApiResponse("Tweet deleted successfully",true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    private ResponseEntity<List<TweetDto>> getAllTweets(
            @RequestHeader("Authorization") String jwt) throws UserException, TweetException{
        User user = userService.findUserProfileByJwt(jwt);
        List<Tweet> tweets= tweetService.findAllTweets();
        List<TweetDto> tweettDtos = TweetDtoMapper.toTweettDtos(tweets, user);
        return new ResponseEntity<>(tweettDtos, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    private ResponseEntity<List<TweetDto>> getUsersAllTweets(@PathVariable Long userId,
            @RequestHeader("Authorization") String jwt) throws UserException, TweetException{
        User user = userService.findUserProfileByJwt(jwt);
        List<Tweet> tweets= tweetService.getUserTweet(user);
        List<TweetDto> tweettDtos = TweetDtoMapper.toTweettDtos(tweets, user);
        return new ResponseEntity<>(tweettDtos, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/likes")
    private ResponseEntity<List<TweetDto>> findTweetByLikesContainsUser(@PathVariable Long userId,
                                                             @RequestHeader("Authorization") String jwt) throws UserException, TweetException{
        User user = userService.findUserProfileByJwt(jwt);
        List<Tweet> tweets= tweetService.findByLikesContainsUser(user);
        List<TweetDto> tweettDtos = TweetDtoMapper.toTweettDtos(tweets, user);
        return new ResponseEntity<>(tweettDtos, HttpStatus.OK);
    }


}
