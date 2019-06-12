package br.edu.uniopet.messageapi.controller;

import br.edu.uniopet.messageapi.model.Message;
import br.edu.uniopet.messageapi.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("list/")
    public List<Message> list(){
        return service.list();
    }
}
