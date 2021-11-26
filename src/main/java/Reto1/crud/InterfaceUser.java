
package Reto1.crud;

import Reto1.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceUser extends CrudRepository <User, Integer> {
    
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
