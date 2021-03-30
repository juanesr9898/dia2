package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.exceptios.IdNotFoundException;
import co.edu.utp.isc.gia.restuser.exceptios.InvalidEmailException;
import co.edu.utp.isc.gia.restuser.exceptios.InvalidNameException;
import co.edu.utp.isc.gia.restuser.exceptios.InvalidPasswordException;
import co.edu.utp.isc.gia.restuser.exceptios.UserNotFoundException;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.modelmapper.ModelMapper;


public class UserServiceTest {
    
    public UserServiceTest() {
    }
    
    private UserRepository userRepository;  //Objeto imitador, objeto dummie
    private ModelMapper modelMapper;
    
    @BeforeEach
    public void setUp(){
        userRepository = Mockito.mock(UserRepository.class);
        modelMapper = new ModelMapper();
    }
        
    @Test
    public void testSave() 
            throws UserNotFoundException, IdNotFoundException, 
            InvalidNameException, InvalidEmailException, 
            InvalidPasswordException {
        
         System.out.println("Save");
        
        User resulted = new User(1L, "juanesr9898", "123456", "Juanes", "juanes.9898@hotmail.com");
        when(userRepository.save(any(User.class))).thenReturn(resulted);
        
        UserDto user = new UserDto(1L, "JUANESR9898", "123456", "Juanes", "juanes.9898@hotmail.com");
        UserService instance = new UserService(userRepository, modelMapper);
        UserDto result = instance.save(user);        
        
        UserDto expResult = new UserDto(1L, "juanesr9898", "123456", "Juanes", "juanes.9898@hotmail.com");      
        
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getId(), result.getId());
        
    }
//
//    @Test
//    public void testListAll() throws UserNotFoundException {
//        System.out.println("listAll");
//        UserService instance = new UserService(userRepository, modelMapper);
//        List<UserDto> expResult = null;
//        List<UserDto> result = instance.listAll();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testFindOne() throws IdNotFoundException, UserNotFoundException {
//        System.out.println("findOne");
//        Long id = null;
//        UserService instance = new UserService(userRepository, modelMapper);
//        UserDto expResult = null;
//        UserDto result = instance.findOne(id);
//        assertEquals(expResult.getId(), result.getId());
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdateOne() throws UserNotFoundException, IdNotFoundException {
//        System.out.println("updateOne");
//        Long id = null;
//        UserDto user = null;
//        UserService instance = new UserService(userRepository, modelMapper);
//        UserDto expResult = null;
//        UserDto result = instance.updateOne(id, user);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testRemoveOne() throws UserNotFoundException, IdNotFoundException {
//        System.out.println("removeOne");
//        Long id = 1L;
//        UserService instance = new UserService(userRepository, modelMapper);
//        UserDto expResult = new UserDto(1L, "juanesr9898", "123456", "Juanes", "juanes.9898@hotmail.com"); ;
//        UserDto result = instance.removeOne(id);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }   
}