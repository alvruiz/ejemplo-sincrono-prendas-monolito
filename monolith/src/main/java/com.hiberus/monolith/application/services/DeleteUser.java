package com.hiberus.monolith.application.services;

import com.hiberus.monolith.domain.ports.in.DeleteUserUseCase;
import com.hiberus.monolith.domain.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class DeleteUser implements DeleteUserUseCase {
    private final UserPort garmentPort;

    @Override
    public boolean deleteUser(String dni) {
        return garmentPort.deleteUser(dni);
    }
}
