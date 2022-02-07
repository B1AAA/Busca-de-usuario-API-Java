package br.com.projetoudemy.api.resources;

import br.com.projetoudemy.api.domain.User;
import br.com.projetoudemy.api.dto.UserDto;
import br.com.projetoudemy.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/user")
public class UserResources {

@Autowired
private ModelMapper mapper;
    @Autowired
    private UserService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Integer id){

        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDto.class));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok()
                .body((service.findAll()
                        .stream().map(x->mapper.map(x,UserDto.class)).collect(Collectors.toList())));
    }
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto obj){

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(service.create(obj).getId()).toUri();

        return ResponseEntity.created(uri).build();

    }
}
