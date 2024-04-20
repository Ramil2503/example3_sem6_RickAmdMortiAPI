package com.example.example4sem6_rikky_and_morty_rest.service;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class ServiceApiImpl implements ServiceApi{

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Autowired
    private Environment env;

    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(env.getProperty("CHARACTER_API"), HttpMethod.GET,entity, Characters.class);

        return responce.getBody();
    }

    @Override
    public Result getCharacter(int id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String path = Objects.requireNonNull(env.getProperty("CHARACTER_API")).concat("/").concat(String.valueOf(id));
        ResponseEntity<Result> responce = template.exchange(path, HttpMethod.GET, entity, Result.class);
        return responce.getBody();
    }
}
