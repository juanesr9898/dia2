package co.edu.utp.isc.gia.restuser.exceptios;

import static javassist.CtMethod.ConstParameter.string;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
        
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidPasswordException extends Exception{
    
    public InvalidPasswordException(){
        super("Invalid Password");
    }
    
    public InvalidPasswordException(int Password){
        super( "Password must contain 5 or more characters");
    }
}
