package com.example.demoEs_CrudTest;

import com.example.demoEs_UnitTest.DemoEsUnitTestApplication;
import com.example.demoEs_UnitTest.Repository.UserRepo;
import com.example.demoEs_UnitTest.entities.User;
import com.example.demoEs_UnitTest.models.DTO.UserDTO;
import com.example.demoEs_UnitTest.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = DemoEsUnitTestApplication.class)

public class ServicesTests {

    @Autowired
    private UserService userService;

    @Mock
    private ModelMapper mapper;

    @MockBean
    private UserRepo userRepo;

    @Test
    public void testCreateStudent() {
        UserDTO u = new UserDTO();
        u.setId(1L);
        u.setName("Davide");
        u.setSurname("Busà");

        User user = new User();
        user.setId(1L);
        user.setName("Davide");
        user.setSurname("Busà");

        User saved = new User();
        saved.setId(1L);
        saved.setName("Davide");
        saved.setSurname("Busà");

        when(mapper.map(u, User.class)).thenReturn(user);
        when(userRepo.saveAndFlush(any(User.class))).thenReturn(saved);
        when(mapper.map(saved, UserDTO.class)).thenReturn(u);

        UserDTO created = userService.createUser(u);
        assertEquals("Davide", created.getName());
        assertEquals("Busà", created.getSurname());
    }

    @Test
    public void testGetStudentById() {
        User u = new User();
        u.setId(1L);
        u.setName("Davide");
        u.setSurname("Busà");
        when(userRepo.findById(1L)).thenReturn(Optional.of(u));
        User found = userService.findById(1L);
        assertEquals("Davide", found.getName());
    }

    @Test
    public void testUpdate() {
        User u = new User();
        u.setId(1L);
        u.setName("Davide");
        u.setSurname("Busà");

        UserDTO newUser = new UserDTO();
        newUser.setName("Bilbo");
        newUser.setSurname("Baggins");

        when(userRepo.findById(1L)).thenReturn(Optional.of(u));
        when(userRepo.saveAndFlush(any(User.class))).thenReturn(u);
        User updated = userService.updateUser(1L, newUser);
        assertEquals("Bilbo", updated.getName());
        assertEquals("Baggins", updated.getSurname());
    }
    @Test
    public void testDelete(){
        User u = new User();
        u.setId(1L);
        u.setName("Davide");
        u.setSurname("Busà");

        when(userRepo.findById(1L)).thenReturn(Optional.of(u));
        userService.deleteUser(1L);

    }
}


