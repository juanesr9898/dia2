package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import co.edu.utp.isc.gia.restuser.exceptios.UserNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;     
    private ModelMapper modelMapper = new ModelMapper();
    
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDto save(UserDto user) {       
        //modelMapper.map permite mapear propiedades de un tipo de objeto 
        //a otro tipo de objeto permitiendo copiar también los datos 
        //de las referencias a los objetos que contengan.
        User myUser = modelMapper.map(user, User.class);
        UserDto resp = modelMapper.map(myUser, UserDto.class);
        myUser = userRepository.save(myUser);        
        return resp;
    }
    
    public List<UserDto> listAll() throws UserNotFoundException {
        //Llamo la función findaAll de userRepository 
        //Y el llamado que hago lo convierto en una lista de tipo User
        List<User> users = (List<User>) userRepository.findAll();
        if (users == null || users.isEmpty()){
            throw new UserNotFoundException();
        }
        else{
            List<UserDto> userDto;
            userDto = new ArrayList<>();
            users.forEach((user) -> {
                //Creamos un user que recorre users
                userDto.add(modelMapper.map(user, UserDto.class));
            });
            return userDto;
        }       
    }
    
    public UserDto findOne(Long id) throws UserNotFoundException {        
        Optional<User> user = userRepository.findById(id); //Llamo la función findaAll de userRepository 
        if (user.isPresent()) {            
            return modelMapper.map(user.get(), UserDto.class);
        }else{
            throw new UserNotFoundException(id);
        }                   
    }
    
    public UserDto updateOne(Long id, UserDto user) throws UserNotFoundException {
        List<UserDto> users = listAll(); //Creo users para tenerlos en una lista
        boolean searchID = searchById(id, users);  // Y aquí busco su id, a ver si existe
        if (searchID != false) {
            throw new UserNotFoundException(id);
        }else{
            user.setId(id);
            userRepository.save(modelMapper.map(user, User.class));    
            return findOne(id);
        }
    }
    
    public UserDto removeOne(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        UserDto userDto = new UserDto();
        if (user.isPresent()) {
            userDto = modelMapper.map(user.get(), UserDto.class);
            userRepository.deleteById(id);
            return userDto;
        }else{
            throw new UserNotFoundException(id);
        }
    }
    
    private boolean searchById (Long id, List<UserDto> users) {
        for (int i=0; i<users.size(); i++) {
            if (id.equals(users.get(i).getId())) 
                return true;               
        }
        return false;
    }
}