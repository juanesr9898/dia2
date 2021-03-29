package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.exceptios.IdNotFoundException;
import co.edu.utp.isc.gia.restuser.exceptios.InvalidEmailException;
import co.edu.utp.isc.gia.restuser.exceptios.InvalidNameException;
import co.edu.utp.isc.gia.restuser.exceptios.InvalidPasswordException;
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

    public UserDto save(UserDto user) 
            throws UserNotFoundException, IdNotFoundException, 
            InvalidNameException, InvalidEmailException, 
            InvalidPasswordException {  
        //Validar información 
        
        if(user == null){
            throw new UserNotFoundException("Invalid User Data");
        }else if(user.getUsername() == null || user.getUsername().isEmpty()){
            throw new UserNotFoundException("Invalid Username");
        }else if(user.getEmail() == null || user.getEmail().isEmpty()){
            throw new InvalidEmailException();
        }else if(user.getId() == null || user.getId().toString().isEmpty()){
            throw new IdNotFoundException();
        }else if(user.getName() == null || user.getName().isEmpty()){
            throw new InvalidNameException();
        }else if(user.getPassword() == null || user.getPassword().isEmpty()){
            throw new InvalidPasswordException();
        }else if(user.getPassword().length() < 5){
            throw new InvalidPasswordException(user.getPassword().length());
        }
        
        //modelMapper.map permite mapear propiedades de un tipo de objeto 
        //a otro tipo de objeto permitiendo copiar también los datos 
        //de las referencias a los objetos que contengan.
        //Procesamos la información
        
        User myUser = modelMapper.map(user, User.class);
        myUser.setUsername(myUser.getUsername().toLowerCase());
        myUser = userRepository.save(myUser);         
        UserDto resp = modelMapper.map(myUser, UserDto.class);       
        return resp;
    }
    
    public List<UserDto> listAll() throws UserNotFoundException {
        //Llamo la función findaAll de userRepository 
        //Y el llamado que hago lo convierto en una lista de tipo User
        List<User> users = (List<User>) userRepository.findAll();
        List<UserDto> userDto = null;
            if (users == null || users.isEmpty()){
                throw new UserNotFoundException("No Existing Users Yet");
            }else{
                users.forEach((user) -> {userDto.add(modelMapper.map(user, UserDto.class));});
                //Creamos un user que recorre users                
                return userDto;
           }       
    }
    
    public UserDto findOne(Long id) throws IdNotFoundException, UserNotFoundException {        
        Optional<User> user = userRepository.findById(id); //Llamo la función findaAll de userRepository 
        
        if(id == null || id.toString().isEmpty()){
            throw new IdNotFoundException();
        }
        else if (!user.isPresent()){
            throw new IdNotFoundException(id);
        }
        else if (user == null){
            throw new UserNotFoundException("Invalid User Data");
        }
        return modelMapper.map(user.get(), UserDto.class);
    }
    
    public UserDto updateOne(Long id, UserDto user) 
            throws IdNotFoundException, UserNotFoundException {
        List<UserDto> users = listAll(); //Creo users para tenerlos en una lista
        boolean searchID = searchById(id, users);  // Y aquí busco su id, a ver si existe
        
        if(id == null || id.toString().isEmpty()){
            throw new IdNotFoundException();
        }
        else if(user == null){
            throw new UserNotFoundException("Invalid User Data");
        }
        else if (searchID != false) {
            throw new IdNotFoundException(id);
        }
        user.setId(id);
        userRepository.save(modelMapper.map(user, User.class));    
        return findOne(id);
    }
    
    public UserDto removeOne(Long id) 
            throws IdNotFoundException, UserNotFoundException {
        
        if(id == null || id.toString().isEmpty()){
            throw new  IdNotFoundException(id);
        }    
        
        Optional<User> user = userRepository.findById(id);
        
        if (!user.isPresent()) {
            throw new IdNotFoundException(id);
        }
        if(user == null){
            throw new UserNotFoundException("Invalid User Data");
        }
        
        UserDto userDto = new UserDto();
        userDto = modelMapper.map(user.get(), UserDto.class);
        userRepository.deleteById(id);
        return userDto;        
    }
    
    private boolean searchById (Long id, List<UserDto> users) {
        for (int i=0; i<users.size(); i++) {
            if (id.equals(users.get(i).getId())) 
                return true;               
        }
        return false;
    }
}
