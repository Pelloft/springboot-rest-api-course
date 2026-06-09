package com.cursoapis.cursoIntroduccionApis.controller;

import com.cursoapis.cursoIntroduccionApis.entity.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/messages")
public class messageController {
    private List<Message> mensajes = new ArrayList<>();

    public messageController() {
        mensajes.add(new Message(1, "Prueba desarorollo de ApiRestFull"));
        mensajes.add(new Message(2, "Prueba desarorollo de ApiRestFull 2"));
    }

    @GetMapping
    public List<Message> getMessages() {
        return mensajes;
    }
}
