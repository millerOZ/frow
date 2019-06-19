package net.robertocrespo.microservices.users.service;

import net.robertocrespo.microservices.users.model.User;
import java.util.List;


public interface UserService {


   List<User> findAll();
	

    User findByUserId(String userId);


    User saveUser(User user);

    void updateUser(User user);

   
    void deleteUser(String userId);
}
