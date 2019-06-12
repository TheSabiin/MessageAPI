package br.edu.uniopet.messageapi.controller;

import br.edu.uniopet.messageapi.model.Message;
import br.edu.uniopet.messageapi.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/messages/")
public class MessagesController {

    @Resource
    private MessageService service;

    @PostMapping("send/")
    public Message send(@RequestBody Message request) {
        return service.send(request);
    }

    @PostMapping("save/")
    public Message save(@RequestBody Message request) {
        return service.save(request);
    }
}
