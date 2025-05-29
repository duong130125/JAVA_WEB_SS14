package ra.session_14.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session_14.model.User;
import ra.session_14.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean create(User user) {
        return userRepository.create(user);
    }
}
