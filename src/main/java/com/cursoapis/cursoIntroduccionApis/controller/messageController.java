package com.cursoapis.cursoIntroduccionApis.controller;
import com.cursoapis.cursoIntroduccionApis.entity.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/messages")
public class messageController {
    private List<Message> mensajes = new ArrayList<>();

    public messageController() {
        mensajes.add(new Message(1, "Prueba 1 desarorollo de ApiRestFull"));
        mensajes.add(new Message(2, "Prueba 2 desarorollo de ApiRestFull"));
        mensajes.add(new Message(3, "Prueba 3 desarorollo de ApiRestFull"));
    }

    @GetMapping
    public List<Message> getMessages() {
        return mensajes;
    }

    @GetMapping("/{id}")
    public Message obtenerMensajePorId(@PathVariable int id){
        Optional<Message> message = mensajes.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
        return message.orElse(null);
    }

    @PostMapping
    public Message crearMensaje(@RequestBody Message mensaje){
        mensajes.add(mensaje);
        return mensaje;
    }

    @DeleteMapping("/{id}")
    public Message eliminarMensaje(@PathVariable int id){
        mensajes.removeIf(m -> m.getId() == id);
        return null;
    }

}
