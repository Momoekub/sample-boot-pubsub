package lab.microservice.messenger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class GreetingsListener {

	private static final Logger log = LoggerFactory.getLogger(GreetingsListener.class);

	@Value("${app.kafka.topic:greetings}")
	private String topicName;

	@KafkaListener(topics = "${app.kafka.topic:greetings}", groupId = "messenger-group")
	public void onMessage(ConsumerRecord<String, String> record) {
		log.info("Received from topic {} partition {} offset {}: {}",
				record.topic(), record.partition(), record.offset(), record.value());
	}
}


