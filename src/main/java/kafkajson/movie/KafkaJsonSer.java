/*
 * @author: Francesca
 * @exercise
 */

package kafkajson.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
// To create a serializer class
import org.apache.kafka.common.serialization.Serializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class KafkaJsonSer implements Serializer<Object> {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	// 1 Metodo config
	@Override
	public void configure(Map map, boolean b) {

	}
	// 2 Metodo ser/de
	@Override
	public byte[] serialize(String s, Object o) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsBytes(o);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return retVal;
	}

	// 3 Metodo
	@Override
	public void close() {

	}
}