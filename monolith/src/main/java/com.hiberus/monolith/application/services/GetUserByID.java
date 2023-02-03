package com.hiberus.monolith.application.services;


import com.hiberus.monolith.domain.model.User;
import com.hiberus.monolith.domain.ports.in.GetUserByIDUseCase;
import com.hiberus.monolith.domain.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class GetUserByID implements GetUserByIDUseCase {
    private final UserPort userPort;

    @Override
    public User getUser(String id) {
        return userPort.getUser(id);
    }
}
