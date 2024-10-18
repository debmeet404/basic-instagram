package in.debmeetbanerjee.service;

import in.debmeetbanerjee.entity.User;
import in.debmeetbanerjee.exception.ResourceNotFoundException;
import in.debmeetbanerjee.repository.UserRepo;
import in.debmeetbanerjee.util.MiscUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static in.debmeetbanerjee.util.Constants.RESOURCE_NOT_FOUND;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        user.setId(MiscUtil.getRandomUuid());
        // Password needs to be hashed before saving
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public User updateUser(User user) {
        findUserById(user.getId());
        return saveUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepo.delete(findUserById(id));
    }

    @Override
    public boolean doesUserExist(String id) {
        try {
            findUserById(id);
        } catch (ResourceNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean doesUserExistByEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        return Objects.nonNull(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    private User findUserById(String id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty()) {
            log.error("User Not Found In DB userId : {}", id);
            throw new ResourceNotFoundException(RESOURCE_NOT_FOUND);
        }
        return optionalUser.get();
    }

}
