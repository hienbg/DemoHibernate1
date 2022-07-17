package com.vti.rw41.entity;

import com.vti.rw41.enumurations.AccountStatus;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "account")
@Getter
@Setter
@ToString
@Generated
public class Account {
    @Id
    @GeneratedValue(generator = "accountIdSeq")// Su dung sequence
    @SequenceGenerator( // Khai bao sequence
            sequenceName = "accountIdSeq", //Ten cua sequence
            name="accountIdSeq", // Ten sequence
            initialValue = 10, // Gia tri dau tien cua sequence
            allocationSize = 3 // Buoc nhay cua sequence
    )
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    private String fullName;
    private LocalDate createDate;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
}