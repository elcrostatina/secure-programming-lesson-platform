package it.fdm.backend.entities;

import java.util.UUID;

import it.fdm.backend.enums.Operation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "privilege")
public class Privilege extends BaseEntity {

	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID userId;

	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID videoId;

	@Column(name = "operation")
	private Operation operation;

}
