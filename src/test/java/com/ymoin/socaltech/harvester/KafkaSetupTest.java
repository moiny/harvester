package com.ymoin.socaltech.harvester;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * this class tests the various KAFKA operations to ascertain that everything is 
 * working  fine
 * @author ymoin
 */

public class KafkaSetupTest {
	public static void main(String[] args){
		Properties props = new Properties();
		props.put("metadata.broker.list","localhost:9092");
		props.put("serializer.class","kafka.serializer.StringEncoder");
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);
		
		
		KeyedMessage<String, String> keyedMessage = new KeyedMessage<String, String>("events", "first_message");
		producer.send(keyedMessage);
	}
}
