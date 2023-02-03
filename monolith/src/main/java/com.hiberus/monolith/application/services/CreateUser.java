package com.hiberus.monolith.application.services;


import com.hiberus.monolith.domain.model.User;
import com.hiberus.monolith.domain.ports.in.CreateUserUseCase;
import com.hiberus.monolith.domain.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CreateUser implements CreateUserUseCase {
    private final UserPort userPort;

    @Override
    public boolean createUser(User user){
        return userPort.createUser(user);
    }
}
