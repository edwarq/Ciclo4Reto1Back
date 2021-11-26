/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto1.repository;

import Reto1.crud.InterfaceUser;
import Reto1.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */

@Repository
public class UserRepository {
    
    @Autowired
    private InterfaceUser interUser;
    
    public List<User> getAll(){
        return (List<User>) interUser.findAll();
    }
    
    public Optional<User> getUser(int id){
        return interUser.findById(id);
    }
    
    public User Save(User user){
        return interUser.save(user);
    }
    
    public boolean existeEmail(String email){
        Optional<User> usuario = interUser.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> autenticarUsuario(String email, String password){
        return interUser.findByEmailAndPassword(email, password);
    }
}
