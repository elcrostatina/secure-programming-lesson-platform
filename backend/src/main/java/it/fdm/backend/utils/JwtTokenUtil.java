package it.fdm.backend.utils;


import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;


@Component
public class JwtTokenUtil implements Serializable {
    public String generateToken() {
        return UUID.randomUUID().toString();
    }
}