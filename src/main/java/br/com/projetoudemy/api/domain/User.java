package br.com.projetoudemy.api.domain;

import lombok.*;

import javax.persistence.*;
@Data//annotation do lombok que cria os construtores
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)//Coluna email não pode se repetir
    private String email;
    private String password;
}
