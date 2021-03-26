package co.edu.utp.isc.gia.restuser.exceptios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
        
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Found")
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}