package br.com.projetoudemy.api.services.impl;

import br.com.projetoudemy.api.domain.User;
import br.com.projetoudemy.api.dto.UserDto;
import br.com.projetoudemy.api.repositories.UserRepository;
import br.com.projetoudemy.api.services.UserService;


import br.com.projetoudemy.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User>  obj=  repository.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
    }
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDto obj) {
        return repository.save(mapper.map(obj,User.class));
    }
}
