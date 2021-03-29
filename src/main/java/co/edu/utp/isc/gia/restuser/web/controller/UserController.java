package co.edu.utp.isc.gia.restuser.web.controller;

import co.edu.utp.isc.gia.restuser.exceptios.IdNotFoundException;
import co.edu.utp.isc.gia.restuser.exceptios.InvalidEmailException;
import co.edu.utp.isc.gia.restuser.exceptios.InvalidNameException;
import co.edu.utp.isc.gia.restuser.exceptios.InvalidPasswordException;
import co.edu.utp.isc.gia.restuser.exceptios.UserNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import co.edu.utp.isc.gia.restuser.service.UserService;
       
@RestController
@RequestMapping("user")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping()
    public UserDto save(@RequestBody UserDto user) throws 
            UserNotFoundException, IdNotFoundException, 
            InvalidNameException, InvalidEmailException, 
            InvalidPasswordException, InvalidPasswordException{
        return userService.save(user); 
    }
    
//    @PostMapping
//    public UserDto insert (@RequestBody UserDto user) throws UserNotFoundException{
//        if(user == null){
//            throw new UserNotFoundException("Invalid User Data");
//        }
//        UserDto resp;
//        try{
//            resp = userService.save(user);
//        } catch (UserNotFoundException ex){
//            throw new UserNotFoundException(ex.getMessage());
//        }      
//        return resp;
//    }
    
    @GetMapping
    public List<UserDto> listAll() throws UserNotFoundException {
        return userService.listAll();
    }
    
    @GetMapping("/{id}")
    public UserDto findOne(@PathVariable("id") Long id) throws UserNotFoundException, IdNotFoundException {
        return userService.findOne(id);
    }
    
    @PutMapping("/{id}")
    public UserDto updateOne(@PathVariable Long id,@RequestBody UserDto user) throws UserNotFoundException, IdNotFoundException {
        return userService.updateOne(id, user);
    }
    
    @DeleteMapping("/{id}")
    public UserDto removeOne(@PathVariable Long id) throws IdNotFoundException {
        return userService.removeOne(id);
    }
}
