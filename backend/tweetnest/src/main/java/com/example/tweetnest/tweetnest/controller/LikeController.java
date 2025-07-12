package com.example.tweetnest.tweetnest.controller;

import com.example.tweetnest.tweetnest.dto.LikeDto;
import com.example.tweetnest.tweetnest.dto.mapper.LikeDtoMapper;
import com.example.tweetnest.tweetnest.exception.TweetException;
import com.example.tweetnest.tweetnest.exception.UserException;
import com.example.tweetnest.tweetnest.model.Like;
import com.example.tweetnest.tweetnest.model.User;
import com.example.tweetnest.tweetnest.service.LikeService;
import com.example.tweetnest.tweetnest.service.UserService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeController {

    @Autowired
    private UserService userService;
    @Autowired
    private LikeService likeService;

    @PostMapping("/{tweetId}/likes")
    public ResponseEntity<LikeDto> likeTweet(@PathVariable Long tweetId,
                                             @RequestHeader("Authorization") String jwt)
            throws UserException, TweetException {

        User user= userService.findUserProfileByJwt(jwt);
        Like like = likeService.likeTweet(tweetId,user);
        LikeDto likeDto = LikeDtoMapper.toLikeDto(like,user);
        return new ResponseEntity<>(likeDto, HttpStatus.CREATED);
    }

    @GetMapping("/tweet/{tweetId}")
    public ResponseEntity<List<LikeDto>> getAllLikes(@PathVariable Long tweetId,
                                                     @RequestHeader("Authorization") String jwt)
            throws UserException, TweetException {

        User user= userService.findUserProfileByJwt(jwt);
        List<Like> like = likeService.getAllLikes(tweetId);
        List<LikeDto> likeDtos = LikeDtoMapper.toLikeDtos(like, user);
        return new ResponseEntity<>(likeDtos,HttpStatus.OK);

    }


}
