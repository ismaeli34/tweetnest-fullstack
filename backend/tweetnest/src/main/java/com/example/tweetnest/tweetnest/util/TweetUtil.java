package com.example.tweetnest.tweetnest.util;

import com.example.tweetnest.tweetnest.model.Like;
import com.example.tweetnest.tweetnest.model.Tweet;
import com.example.tweetnest.tweetnest.model.User;

public class TweetUtil {

    public final static boolean isLikedByReqUser(User reqUser, Tweet tweet){
        // one by one like ko check karunga, iske andar
        // jo user ki id hai, requser se match karti hai ki nahi -> agar match karti hai to return true karunga

        for (Like like:tweet.getLikes()){
            if (like.getUser().getId().equals(reqUser.getId())){
                return true;
            }
        }
        return false;

    }

    public final static boolean isRetwittedByReqUser(User reqUser, Tweet tweet){

        // one by one retweet user ko check karunga, iske andar
        // jo user ki id hai requser se match karti hai ki nahi -> agar match karti hai to return true karunga

        for (User user:tweet.getRetweetUser()){
            if (user.getId().equals(reqUser.getId())){
                return true;
            }
        }
        return false;

    }


}
