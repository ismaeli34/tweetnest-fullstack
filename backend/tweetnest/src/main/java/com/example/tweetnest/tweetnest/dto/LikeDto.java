package com.example.tweetnest.tweetnest.dto;

import com.example.tweetnest.tweetnest.model.User;
import lombok.Data;

@Data
public class LikeDto {
    private Long id;
    private UserDto user;
    private TweetDto tweetDto;
}
