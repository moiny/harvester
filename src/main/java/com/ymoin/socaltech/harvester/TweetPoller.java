package com.ymoin.socaltech.harvester;

import com.ymoin.socaltech.harvester.service.TweetPollerService;
import com.ymoin.socaltech.harvester.service.TweetPollerServiceImpl;

import twitter4j.RawStreamListener;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/**
 * program running for a long time and creates the logs which would later be used for analysis
 * 
API key	8NxwAiMpKarTUCuR6qg8gkdV2
API secret	QFQlBGadZCAD9EVRRDSNzAj1OJoiWtAIyHEo8DVXa6xoNAdnzD
Access token	487314862-wBeRK59kjml6Dt45x9EumddmqIGMGjaKPhQ2hjtO
Access token secret	8WLyFGSyinJejKC5FbtogtnHzbDWFzK33nAVXnUlTo0BI

 */
public class TweetPoller {
    public static void main( String[] args ){
    	
    	RawStreamListener listener = new RawStreamListener() {
			
			public void onException(Exception arg0) {
				// TODO Auto-generated method stub
			}
			
			public void onMessage(String tweetJSON) {
				TweetPollerService tweetPollerService = new TweetPollerServiceImpl();
				System.out.println("tweetJSON : "+tweetJSON);
				tweetPollerService.addTweet(tweetJSON);
			}
		};
        
    	TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
    	twitterStream.addListener(listener);
    	twitterStream.sample();
    }
}
