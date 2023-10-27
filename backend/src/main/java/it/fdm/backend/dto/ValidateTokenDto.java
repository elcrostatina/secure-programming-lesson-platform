package it.fdm.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ValidateTokenDto implements Serializable {
    private String localName;
    private String domain;
}
