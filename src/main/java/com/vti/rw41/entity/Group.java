package com.vti.rw41.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="`Group`", catalog = "Hibernate")
@Getter
@Setter
@ToString
@Generated
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "group_name", nullable = false)
    private String groupName;
    private LocalDate createDate;
}
