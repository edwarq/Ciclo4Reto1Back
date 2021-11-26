/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto1.service;

import Reto1.repository.UserRepository;
import Reto1.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository repoUser;
    
    public List<User> getAll(){
       return repoUser.getAll();
   }
     public Optional<User> getUser(int id) {
        return repoUser.getUser(id);
    }
     
    
     public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return repoUser.Save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean existeEmail(String email) {
        return repoUser.existeEmail(email);
    }
    
       public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repoUser.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}