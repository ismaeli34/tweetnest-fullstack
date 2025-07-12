package com.example.tweetnest.tweetnest.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TweetReplyRequest {


    private String content;
    // kis tweet ke liye
    private Long tweetId;
    // reply kab create hua
    private LocalDateTime createdAt;

    private String image;


}
