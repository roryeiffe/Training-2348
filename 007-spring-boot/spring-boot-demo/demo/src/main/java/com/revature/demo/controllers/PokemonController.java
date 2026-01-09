package com.revature.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PokemonController {

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<String> pokemon(@PathVariable("id") Long id) {
        // we want to pull in information from:
        String url = "https://pokeapi.co/api/v2/pokemon/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.toString());
        return response;
    }

}
