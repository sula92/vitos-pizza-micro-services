package com.vitospizza.userservice.model;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User implements SuperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String userName;
    @NotNull
    private String password;

    @NotNull
    private String privilege;

    @NonNull
    @Email(regexp = ".+@.+\\..+")
    private String email;


}
