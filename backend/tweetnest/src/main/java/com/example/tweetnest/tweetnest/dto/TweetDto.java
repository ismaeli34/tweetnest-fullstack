package com.example.tweetnest.tweetnest.dto;

import com.example.tweetnest.tweetnest.model.Like;
import com.example.tweetnest.tweetnest.model.Tweet;
import com.example.tweetnest.tweetnest.model.User;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class TweetDto {

    private Long id;
    private String content;
    private String video;
    private String image;
    private UserDto user;
    private int totalLikes;
    private int totalReplies;
    private int totalRetweets;
    private boolean isLiked;
    private boolean isRetweet;
    private LocalDateTime createdAt;
    private List<Long> retweetUsersId;
    private List<TweetDto> replyTweets;
}
