package br.com.projetoudemy.api.services;

import br.com.projetoudemy.api.domain.User;
import br.com.projetoudemy.api.dto.UserDto;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create (UserDto obj);
    User update(UserDto obj);
    void delete(Integer id);
}
