package it.fdm.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "resource_map")
public class ResourceMap extends BaseEntity {

	@Column(name = "object_name")
	private String objectName;

	@Column(name = "bucket_name")
	private String bucketName;


}
