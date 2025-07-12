package com.example.tweetnest.tweetnest.dto.mapper;

import com.example.tweetnest.tweetnest.dto.TweetDto;
import com.example.tweetnest.tweetnest.dto.UserDto;
import com.example.tweetnest.tweetnest.model.Tweet;
import com.example.tweetnest.tweetnest.model.User;
import com.example.tweetnest.tweetnest.util.TweetUtil;

import java.util.ArrayList;
import java.util.List;

public class TweetDtoMapper {

    public static TweetDto toTweetDto(Tweet tweet, User reqUser){
        UserDto user = UserDtoMapper.toUserDto(tweet.getUser());
        boolean isLiked =  TweetUtil.isLikedByReqUser(reqUser,tweet);
        boolean isRetweeted = TweetUtil.isRetwittedByReqUser(reqUser,tweet);

        List<Long> retweetUserId = new ArrayList<>();

        for(User user1: tweet.getRetweetUser()){
            retweetUserId.add(user1.getId());
        }
        TweetDto tweetDto = new TweetDto();
        tweetDto.setId(tweet.getId());
        tweetDto.setContent(tweet.getContent());
        tweetDto.setCreatedAt(tweet.getCreatedAt());
        tweetDto.setImage(tweet.getImage());
        tweetDto.setTotalLikes(tweet.getLikes().size());
        tweetDto.setTotalReplies(tweet.getReplyTweets().size());
        tweetDto.setTotalRetweets(tweet.getRetweetUser().size());
        tweetDto.setUser(user);
        tweetDto.setLiked(isLiked);
        tweetDto.setRetweet(isRetweeted);
        tweetDto.setRetweetUsersId(retweetUserId);
        tweetDto.setReplyTweets(toTweettDtos(tweet.getReplyTweets(),reqUser));
        tweetDto.setVideo(tweet.getVideo());
        return tweetDto;
    }


    public static List<TweetDto> toTweettDtos(List<Tweet> tweets, User reqUser){
        List<TweetDto> tweetDtos = new ArrayList<>();

        for(Tweet tweet: tweets){
            TweetDto tweetDto = toReplyTweetDto(tweet,reqUser);
            tweetDtos.add(tweetDto);
        }
        return tweetDtos;

    }

    private static TweetDto toReplyTweetDto(Tweet tweet, User reqUser) {
        UserDto user = UserDtoMapper.toUserDto(tweet.getUser());
        boolean isLiked =  TweetUtil.isLikedByReqUser(reqUser,tweet);
        boolean isRetweeted = TweetUtil.isRetwittedByReqUser(reqUser,tweet);

        List<Long> retweetUserId = new ArrayList<>();

        for(User user1: tweet.getRetweetUser()){
            retweetUserId.add(user1.getId());
        }

        TweetDto tweetDto = new TweetDto();
        tweetDto.setId(tweet.getId());
        tweetDto.setContent(tweet.getContent());
        tweetDto.setCreatedAt(tweet.getCreatedAt());
        tweetDto.setImage(tweet.getImage());
        tweetDto.setTotalLikes(tweet.getLikes().size());
        tweetDto.setTotalReplies(tweet.getReplyTweets().size());
        tweetDto.setTotalRetweets(tweet.getRetweetUser().size());
        tweetDto.setUser(user);
        tweetDto.setLiked(isLiked);
        tweetDto.setRetweet(isRetweeted);
        tweetDto.setRetweetUsersId(retweetUserId);
        tweetDto.setVideo(tweet.getVideo());



        return tweetDto;
    }
}
