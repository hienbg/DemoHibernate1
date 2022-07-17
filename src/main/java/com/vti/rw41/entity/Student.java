package com.vti.rw41.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Year;

@Entity
@Data // Thay cho Getter setter, to string
public class Student {
@Id
@GenericGenerator(name="StudentIdGenerator",
strategy = "com.vti.rw41.entity.StudentIdGenerator")
@GeneratedValue(generator = "StudentIdGenerator")
    private String id; //SYYYYxxxx -> S20220001
private String name;


}
