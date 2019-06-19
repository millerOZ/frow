package net.robertocrespo.microservices.users.repository;

import net.robertocrespo.microservices.users.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository{

   
  Optional<List<User>> findAll();

    public Optional<User> findOne(String userId);

    public User saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(String userId);

}
