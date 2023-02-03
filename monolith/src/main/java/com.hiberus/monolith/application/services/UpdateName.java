package com.hiberus.monolith.application.services;

import com.hiberus.monolith.domain.model.User;
import com.hiberus.monolith.domain.ports.in.UpdateNameUseCase;
import com.hiberus.monolith.domain.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UpdateName implements UpdateNameUseCase {
    private final UserPort garmentPort;


    @Override
    public boolean updateName(User user, String name) {
        user.setName(name);
        return garmentPort.createUser(user);
    }


}
