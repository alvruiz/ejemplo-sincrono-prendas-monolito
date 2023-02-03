package com.hiberus.monolith.domain.ports.in;


import com.hiberus.monolith.domain.model.User;

import java.util.List;

public interface GetUserUseCase {
    List<User> getUsers();
}
