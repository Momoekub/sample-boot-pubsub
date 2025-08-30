package lab.microservice.hello;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

	@Value("${app.kafka.topic:greetings}")
	private String topicName;

	@Bean
	public NewTopic greetingsTopic() {
		return new NewTopic(topicName, 1, (short) 1);
	}
}