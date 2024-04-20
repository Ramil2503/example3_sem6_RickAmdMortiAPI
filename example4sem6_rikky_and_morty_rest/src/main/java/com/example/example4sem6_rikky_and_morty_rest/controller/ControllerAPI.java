package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/characters")
    public String getCharacters(Model model) {
        model.addAttribute("characters", serviceApi.getAllCharacters().getResults());
        return "main";
    }

    @GetMapping("/character/{id}")
    public String getCharacter(Model model, @PathVariable int id) {
        model.addAttribute("character", serviceApi.getCharacter(id));
        return "character";
    }
}
