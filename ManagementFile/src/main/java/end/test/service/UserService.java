package end.test.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import end.test.dto.UserRegistrationDto;
import end.test.model.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
