package com.festu.auth.service.user;

import com.festu.auth.model.User;
import com.festu.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByUsername(username);
        if (user != null) return user;

        throw new UsernameNotFoundException("Could not find user with username " + username);
    }

    @Override
    public User getByUsername(String username) {
        return repository.findUserByUsername(username);
    }

}
