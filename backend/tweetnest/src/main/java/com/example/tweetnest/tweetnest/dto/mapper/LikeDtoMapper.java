package com.example.tweetnest.tweetnest.dto.mapper;
import com.example.tweetnest.tweetnest.dto.LikeDto;
import com.example.tweetnest.tweetnest.dto.TweetDto;
import com.example.tweetnest.tweetnest.dto.UserDto;
import com.example.tweetnest.tweetnest.model.Like;
import com.example.tweetnest.tweetnest.model.User;
import java.util.ArrayList;
import java.util.List;


public class LikeDtoMapper {
    public static LikeDto toLikeDto(Like like, User reqUser){
        UserDto userDto = UserDtoMapper.toUserDto(like.getUser());
        UserDto reqUserDto = UserDtoMapper.toUserDto(reqUser);
        TweetDto tweetDto = TweetDtoMapper.toTweetDto(like.getTweet(),reqUser);
        LikeDto likeDto = new LikeDto();
        likeDto.setId(like.getId());
        likeDto.setUser(userDto);
        likeDto.setTweetDto(tweetDto);
        return likeDto;
    }
    public static List<LikeDto> toLikeDtos(List<Like> likes, User reqUser){
        List<LikeDto> likeDtos = new ArrayList<>();
        for (Like like:likes){
            UserDto userDto = UserDtoMapper.toUserDto(like.getUser());
            TweetDto tweetDto = TweetDtoMapper.toTweetDto(like.getTweet(),reqUser);
            LikeDto likeDto = new LikeDto();
            likeDto.setId(like.getId());
            likeDto.setUser(userDto);
            likeDto.setTweetDto(tweetDto);
            likeDtos.add(likeDto);
        }
        return likeDtos;
    }
}
