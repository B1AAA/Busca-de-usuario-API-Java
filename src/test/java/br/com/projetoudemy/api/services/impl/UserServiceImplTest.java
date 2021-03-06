package br.com.projetoudemy.api.services.impl;

import br.com.projetoudemy.api.domain.User;
import br.com.projetoudemy.api.dto.UserDto;
import br.com.projetoudemy.api.repositories.UserRepository;
import br.com.projetoudemy.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {
    public static final Integer ID       = 1;
    public static final String NAME      = "Beatriz";
    public static final String EMAIL     = "beatriz@gmail.com";
    public static final String PASSWORD  = "@123";
    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;


    private User user;
    private UserDto userDto;
    private Optional<User> optionalUser;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();

    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
         when(repository.findById(anyInt())).thenReturn(optionalUser);
        User response= service.findById(ID);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID,response.getId());
        assertEquals(NAME,response.getName());
        assertEquals(EMAIL,response.getEmail());

    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException(){
       when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

       try{
           service.findById(ID);
       }catch(Exception ex){
           assertEquals(ObjectNotFoundException.class,ex.getClass());
       }
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {

    }

    private void startUser(){

        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDto = new UserDto(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}
