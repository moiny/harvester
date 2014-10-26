package com.ymoin.socaltech.harvester.service.messagebroker;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class MessageBrokerServiceImpl implements MessageBrokerService {

	public void sendMessage(String message) {
		Properties props = new Properties();
		props.put("zk.connect", "127.0.0.1:2181");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);
		
		KeyedMessage<String, String> keyedMessage = new KeyedMessage<String, String>("events", "first_message");
		producer.send(keyedMessage);
	}
}
