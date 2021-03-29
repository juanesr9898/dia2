package co.edu.utp.isc.gia.restuser.exceptios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
        
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends Exception{
    public IdNotFoundException(Long id) {
        super("User ID : " +id+ " Not Found");
    }
    public IdNotFoundException() {
        super("Invalid ID");
    }
}
