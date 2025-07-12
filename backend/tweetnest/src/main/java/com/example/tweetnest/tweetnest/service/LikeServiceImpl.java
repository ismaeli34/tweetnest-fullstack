package com.example.tweetnest.tweetnest.service;
import com.example.tweetnest.tweetnest.exception.TweetException;
import com.example.tweetnest.tweetnest.exception.UserException;
import com.example.tweetnest.tweetnest.model.Like;
import com.example.tweetnest.tweetnest.model.Tweet;
import com.example.tweetnest.tweetnest.model.User;
import com.example.tweetnest.tweetnest.repository.LikeRepository;
import com.example.tweetnest.tweetnest.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService{


    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private TweetService tweetService;
    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public Like likeTweet(Long tweetId, User user) throws UserException, TweetException {
        Like likeExist = likeRepository.isLikeExist(user.getId(), tweetId);

        // like ko delete kar dunga toh ye unlike ho jaayega
        if(likeExist!=null){
            likeRepository.deleteById(likeExist.getId());
            return likeExist;
        }
        Tweet tweet = tweetService.findById(tweetId);
        Like like = new Like();
        like.setTweet(tweet);
        like.setUser(user);


        Like savedLike = likeRepository.save(like);
        tweet.getLikes().add(savedLike);
        tweetRepository.save(tweet);
        return savedLike;
    }

    @Override
    public List<Like> getAllLikes(Long tweetId) throws TweetException {

        Tweet tweet = tweetService.findById(tweetId);
        List<Like> likes = likeRepository.findByTweetId(tweetId);

        return likes;
    }
}
