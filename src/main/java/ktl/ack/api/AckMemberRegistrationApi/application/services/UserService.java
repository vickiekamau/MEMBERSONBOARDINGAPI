package ktl.ack.api.AckMemberRegistrationApi.application.services;

import ktl.ack.api.AckMemberRegistrationApi.application.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getUsers();

    User getUsersById(Long user_id);

    User insert(User user);

    void updateUser(Long user_id, User user);

    void deleteUser(Long user_id);
}
