package in.debmeetbanerjee.service;

import in.debmeetbanerjee.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User saveUser(User user);

    Optional<User> getUserById(String id);

    User updateUser(User user);

    void deleteUser(String id);

    boolean doesUserExist(String id);

    boolean doesUserExistByEmail(String email);

    List<User> getAllUsers();
}
