package com.example.tweetnest.tweetnest.repository;

import com.example.tweetnest.tweetnest.model.Tweet;
import com.example.tweetnest.tweetnest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet,Long> {

    List<Tweet> findAllByIsTweetTrueOrderByCreatedAtDesc();

    List<Tweet> findByRetweetUserContainsOrUser_IdAndIsTweetTrueOrderByCreatedAtDesc(User user, Long userId);

    List<Tweet> findByLikesContainingOrderByCreatedAtDesc(User user);

    @Query("SELECT t FROM Tweet t JOIN t.likes l WHERE l.user.id = :userId")
    List<Tweet> findByLikesUser_id(Long userId);
}
