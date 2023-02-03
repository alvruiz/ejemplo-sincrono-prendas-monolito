package com.hiberus.monolith.domain.ports.in;


import com.hiberus.monolith.domain.model.User;

public interface UpdateNameUseCase {

    boolean updateName(User user, String name);
}
