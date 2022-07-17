package com.vti.rw41.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class TestUuid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Type(type = "uuid-char")
    private UUID id;
    private String name;
}
