package com.ymoin.socaltech.harvester.service.messagebroker;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class MessageBrokerServiceImpl implements MessageBrokerService {
	
	private static Producer<String, String> producer = null;
	
	static {
		Properties props = new Properties();
		props.put("metadata.broker.list","localhost:9092");
		props.put("serializer.class","kafka.serializer.StringEncoder");
		ProducerConfig config = new ProducerConfig(props);
		producer = new Producer<String, String>(config);
	}
	
	
	public void sendMessage(String message) {		
		KeyedMessage<String, String> keyedMessage = new KeyedMessage<String, String>("events", message);
		producer.send(keyedMessage);
		System.out.println("Message sent successfully");
	}
}
