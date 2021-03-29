package co.edu.utp.isc.gia.restuser.exceptios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
        
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidEmailException extends Exception{    
    public InvalidEmailException(){
     super("Invalid Email");
}
}
