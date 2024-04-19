package com.projectoSpring.springboot.backend.apirest.controllers;

import com.projectoSpring.springboot.backend.apirest.models.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class SecurityController {

    @GetMapping("/list")
    public List<Message> list(){
        return Collections.singletonList(new Message("Test list"));
    }

    @PostMapping("/create")
    public Message create(@RequestBody Message message){
        System.out.println("Mensaje guardado: " + message);
        return message;
    }

    @GetMapping("/authorized")
    public Map<String, String> authorized(@RequestParam String code){
        return Collections.singletonMap("code", code);
    }
}
