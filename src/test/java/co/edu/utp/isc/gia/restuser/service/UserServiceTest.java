package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void testSave() {
        User sended = new User(null, "Juanesr9898", "123", "Juanes", "juanes.9898@hotmail.com");
        User resulted = new User(1L, "Juanesr9898", "123", "Juanes", "juanes.9898@hotmail.com");
        when(userRepository.save(sended)).thenReturn(resulted);
        
        UserDto user = new UserDto(null, "JUANESR9898", "123", "Juanes", "juanes.9898@hotmail.com");
        UserService instance = new UserService(userRepository, modelMapper);
        UserDto result = instance.save(user);
        
        UserDto expResult = new UserDto(1L, "Juanesr9898", "123", "Juanes", "juanes.9898@hotmail.com");      
        
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getId(), result.getId());
        
    }
}
