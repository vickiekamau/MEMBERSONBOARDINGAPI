package ktl.ack.api.AckMemberRegistrationApi.application.services;

import ktl.ack.api.AckMemberRegistrationApi.application.model.Member;
import ktl.ack.api.AckMemberRegistrationApi.application.model.User;
import ktl.ack.api.AckMemberRegistrationApi.application.repository.MemberRepository;
import ktl.ack.api.AckMemberRegistrationApi.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public User getUsersById(Long user_id) {
        return userRepository.findById(user_id).get();
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(Long user_id, User user) {
        User users = userRepository.findById(user_id).get();
        users.setEmail(user.getEmail());
        users.setPassword(user.getPassword());
        userRepository.save(users);
    }

    @Override
    public void deleteUser(Long user_id) {
       userRepository.deleteById(user_id);
    }
}
