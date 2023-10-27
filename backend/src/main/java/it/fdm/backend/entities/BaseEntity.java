package it.fdm.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    protected Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    protected Date updatedAt;
}
