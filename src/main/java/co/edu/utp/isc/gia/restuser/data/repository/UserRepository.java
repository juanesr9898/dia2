package co.edu.utp.isc.gia.restuser.data.repository;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    Optional<User> findById (Long id);
    //Sale de la libreria de CrudRepository.java
    //Option permite mostrar de manera explicita (mediante el sistema de tipos)
    //en este caso usamos el tipo User (<User>) 
    //la posibilidad de que un método pueda no devolver el valor deseado. 
    //esto nos obliga a controlar la posible ausencia de valor de manera explicita
    //permitiéndonos elegir un valor alternativo en caso de dicha ausencia.
    
    @Override
    void deleteById (Long id);
}
