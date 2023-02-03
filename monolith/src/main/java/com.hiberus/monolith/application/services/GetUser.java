package com.hiberus.monolith.application.services;

import com.hiberus.monolith.domain.model.User;
import com.hiberus.monolith.domain.ports.in.GetUserUseCase;
import com.hiberus.monolith.domain.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class GetUser implements GetUserUseCase {
    private final UserPort userPort;

    @Override
    public List<User> getUsers() {
        return userPort.getUsers();
    }
}
