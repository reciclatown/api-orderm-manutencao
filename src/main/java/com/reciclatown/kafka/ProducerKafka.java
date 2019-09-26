package com.reciclatown.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciclatown.model.OrdemManutencao;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class ProducerKafka {

    public void enviarEventoKafka(String bootstrapServer, OrdemManutencao ordemManutencao) {
        Properties producerProperties = new Properties();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> myProducer = new KafkaProducer<>(producerProperties);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String ordemAtualizada = mapper.writeValueAsString(ordemManutencao);
            ProducerRecord record = new ProducerRecord<>("ordens-manutencao", ordemAtualizada);
			myProducer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myProducer.close();
        }
    }

}