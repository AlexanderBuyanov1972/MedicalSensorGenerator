 package telran.m2m.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.m2m.dto.Sensor;

@EnableBinding(Source.class)
public class SensorService {
	ObjectMapper mapper = new ObjectMapper();
	@Value("${minid:1}")
	private int minId;
	@Value("${maxid:10}")
	private int maxId;
	@Value("${mindataUBP:100}")
	private int minDataUBP;
	@Value("${maxdataUBP:250}")
	private int maxDataUBP;
	@Value("${min_dataLBP:50}")
	private int minDataLBP;
	@Value("${max_dataLBP:100}")
	private int maxDataLBP;
	@Value("${min_dataPuls:20}")
	private int minDataPuls;
	@Value("${max_dataPuls:250}")
	private int maxDataPuls;
	@Value("${min_dataSugar:10}")
	private int minDataSugar;
	@Value("${max_dataSugar:200}")
	private int maxDataSugar;

	@InboundChannelAdapter(Source.OUTPUT) // логический канал
	String sendSensordata() throws JsonProcessingException {
		int id = getRandom(minId, maxId);
		int dataUBP = getRandom(minDataUBP, maxDataUBP);
		int dataLBP = getRandom(minDataLBP, maxDataLBP);
		int dataPuls = getRandom(minDataPuls, maxDataPuls);
		int dataSugar = getRandom(minDataSugar, maxDataSugar);
		Sensor sensor = new Sensor(LocalDateTime.now().toString(), id, dataUBP, dataLBP, dataPuls, dataSugar);
		System.out.println(sensor);
		return mapper.writeValueAsString(sensor);
	}

	private int getRandom(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

}
