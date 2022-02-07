package br.com.projetoudemy.api.services;

import br.com.projetoudemy.api.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
}
