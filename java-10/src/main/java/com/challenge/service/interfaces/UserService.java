package com.challenge.service.interfaces;

import com.challenge.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Override
    public Optional<User> findById(Long userId) {
        return Optional.empty();
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return null;
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return null;
    }

    @Override
    public User save(User object) {
        return null;
    }
}
