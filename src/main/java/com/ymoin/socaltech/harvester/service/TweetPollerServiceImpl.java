package com.ymoin.socaltech.harvester.service;

import com.ymoin.socaltech.harvester.service.messagebroker.MessageBrokerService;
import com.ymoin.socaltech.harvester.service.messagebroker.MessageBrokerServiceImpl;

public class TweetPollerServiceImpl implements TweetPollerService {

	public void addTweet(String tweetJson) {
		MessageBrokerService messageBrokerService = new MessageBrokerServiceImpl();
		messageBrokerService.sendMessage(tweetJson);
	}
}
