/*
 * @author: Francesca
 * @exercise
 */

package kafkajson.movie;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaService {

	private final Producer<String, MovieObject> kafkaProducer;
	private final Consumer<String, MovieObject> consumer;

	public KafkaService() {

		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");

		kafkaProducer = new KafkaProducer<String, MovieObject>(props);
		//	kafkaProducer = new KafkaProducer<String, MovieObject>(props, new StringSerializer(), new KafkaJsonSer());

		consumer = new KafkaConsumer<String, MovieObject>(props);

		// consumer = new KafkaConsumer<String, MovieObject>(props, new
		// StringDeserializer(),
		// new KafkaJsonDe<MovieObject>(MovieObject.class));
	}

	public void send(MovieObject res) {
		kafkaProducer.send(new ProducerRecord<>("Messaggio Film", res.getId(), res));

	}

	public Consumer<String, MovieObject> consume(String topic) {
		consumer.subscribe(Collections.singletonList(topic));
		return consumer;
	}

}
