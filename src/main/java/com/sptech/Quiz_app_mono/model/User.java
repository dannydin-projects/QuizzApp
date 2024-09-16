package com.sptech.Quiz_app_mono.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

    //private Integer id;
    @Id
    private String username;
    private String password;
}
