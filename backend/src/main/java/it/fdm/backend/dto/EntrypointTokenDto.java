package it.fdm.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EntrypointTokenDto {
    String token;
    UUID id;
}
