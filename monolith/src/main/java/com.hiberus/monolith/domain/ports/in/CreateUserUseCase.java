package com.hiberus.monolith.domain.ports.in;


import com.hiberus.monolith.domain.model.User;

public interface CreateUserUseCase {

    boolean createUser(User user);

}
