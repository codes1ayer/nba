package us.data.nba.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import us.data.nba.entity.ResBean;

@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic, String body){
            kafkaTemplate.send(topic,body);

    }
}
