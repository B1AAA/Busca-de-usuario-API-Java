package br.com.projetoudemy.api.services;

import br.com.projetoudemy.api.domain.User;

public interface UserService {
    User findById(Integer id);
}
