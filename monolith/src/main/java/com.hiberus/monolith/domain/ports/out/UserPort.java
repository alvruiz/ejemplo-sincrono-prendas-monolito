package com.hiberus.monolith.domain.ports.out;


import com.hiberus.monolith.domain.model.User;

import java.util.List;

public interface UserPort {



    boolean createUser(User user);

    boolean deleteUser(String dni);

    List<User> getUsers();

    User getUser(String id);
}
