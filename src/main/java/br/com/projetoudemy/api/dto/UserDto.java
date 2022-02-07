package br.com.projetoudemy.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private String email;
   // @JsonIgnore// PARA NÃO PASSAR A SENHA NO JSON DO POSTMAN
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private String password;
}

