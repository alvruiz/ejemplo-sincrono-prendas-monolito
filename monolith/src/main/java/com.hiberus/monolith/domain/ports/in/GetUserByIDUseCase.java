package com.hiberus.monolith.domain.ports.in;


import com.hiberus.monolith.domain.model.User;

public interface GetUserByIDUseCase {
    User getUser(String id);
}
