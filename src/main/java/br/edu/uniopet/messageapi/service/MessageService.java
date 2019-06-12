package br.edu.uniopet.messageapi.service;

import br.edu.uniopet.messageapi.model.Message;
import br.edu.uniopet.messageapi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

import static br.edu.uniopet.messageapi.util.Asserts.assertNull;

@Service
public class MessageService {

    @Resource
    private MessageRepository repository;

    private RestTemplate httpClient = new RestTemplate();

    @Value("${message.url.save}")
    private String messageSaveUrl;

    @Transactional
    public Message send(Message message) {
        assertNull(message.getTitle(), "Title can not be null");

        Message responseMessage = httpClient.postForObject(messageSaveUrl, message, Message.class);

        return responseMessage;
    }

    @Transactional
    public Message save(Message message){
        message.setCreated(new Date());

        return repository.save(message);
    }

    public List<Message> list(){
        return repository.findAll();
    }
}
