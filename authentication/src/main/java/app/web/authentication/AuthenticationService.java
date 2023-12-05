package app.web.authentication;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
class AuthenticationService {
    private final UserRepository userRepository;

    void registerUser(String login, String email) {
        if (userRepository.existsByLoginOrEmail(login, email))
            throw AuthenticationExceptionFactory.userAlreadyExists(login, email);
        User user = new User(login, email);
        userRepository.save(user);
    }
}
