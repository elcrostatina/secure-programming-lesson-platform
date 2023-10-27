package it.fdm.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "token")
public class Token extends BaseEntity {

    private String localName;

    private String domain;
    
    private String token;
    
    private String state;
}