/*
 * @author: Francesca
 * @exercise
 */

package kafkajson.movie;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class App {

	public static void main(String[] args) {

		KafkaService kf = new KafkaService();

		// send message 1-10
		for (int i = 0; i < 10; i++) {
			kf.send(new MovieObject(String.valueOf(i), "Anno", (3 + i)));
		}

		// consume message
		final Consumer<String, MovieObject> consumer = kf.consume("Messaggio Film");

		final int i = 100;
		int noRecordsCount = 0;

		while (true) {
			// foreach, lo stessa funzione per COUCHBASE!
			final ConsumerRecords<String, MovieObject> consumerRecords = consumer.poll(1000);
			if (consumerRecords.count() == 0) {

				noRecordsCount++;

				if (noRecordsCount > i)
					break;
				else
					continue;
			}
			consumerRecords.forEach(record -> {
				System.out.println(record.value());

			});
			consumer.commitAsync();
		}
		consumer.close();

	}
}
