package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import co.edu.utp.isc.gia.restuser.exceptios.UserNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
        
    private List<UserDto> users = new ArrayList<>(); 
     

    public UserDto save(UserDto user) {
        if(users.isEmpty()){
            user.setId(1L);
        }else{
            user.setId(users.get(users.size()-1).getId() + 1L);
        }
        users.add(user);
        
        return user;
    }
    
    public List<UserDto> listAll() {
        if (users.isEmpty()){
            System.out.println("No hay usuarios agregados");
            return null;
        }
        return users;
    }
    
    public UserDto findOne(Long id) throws UserNotFoundException {
        int i = searchById(id, users);
        if (i == -1) {
            throw new UserNotFoundException("User id : "+id+ " not Found" );
        }else{
            return users.get(i);
        }
    }
    
    public UserDto updateOne(Long id, UserDto user) throws UserNotFoundException {
        int i = searchById(id, users);
        if (i == -1) {
            throw new UserNotFoundException("User id : "+id+ " not Found" );
        }else{
            user.setId(id);
            users.set(i, user);        
            return users.get(i);
        }
    }
    
    public UserDto removeOne(Long id) throws UserNotFoundException {
        int i = searchById(id, users);
        if (i == -1) {
            throw new UserNotFoundException("User id : "+id+ " not Found" );
        }else{
            return users.remove(i);
        }
    }
    
    private int searchById (Long id, List<UserDto> users) {
        for (int i=0; i<users.size(); i++) {
            if (id.equals(users.get(i).getId())) return i;               
        }
        return -1;
    }
    
}