package com.example.demo.data.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    Long id;

    @Column(unique=true, nullable=false)
    String name;

}
