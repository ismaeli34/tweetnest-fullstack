package com.example.tweetnest.tweetnest.repository;

import com.example.tweetnest.tweetnest.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {

    @Query("SELECT L FROM Like L where L.user.id=:userId AND L.tweet.id=:tweetId")
    public Like isLikeExist(@Param("userId") Long userId,@Param("tweetId") Long twitId);

    @Query("SELECT L FROM Like L WHERE L.tweet.id=:tweetId")
    public List<Like> findByTweetId(@Param("tweetId") Long tweetId);

}
