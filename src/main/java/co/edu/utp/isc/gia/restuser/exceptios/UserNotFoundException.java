package co.edu.utp.isc.gia.restuser.exceptios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
        
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("User Not Found");
    }
    public UserNotFoundException(Long id) {
        super("User ID : " +id+ " Not Found");
    }
}