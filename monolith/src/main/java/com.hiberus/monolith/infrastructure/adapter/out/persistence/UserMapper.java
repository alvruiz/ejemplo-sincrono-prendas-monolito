package com.hiberus.monolith.infrastructure.adapter.out.persistence;

import com.hiberus.monolith.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    static User mapToDomainEntity(UserEntity entity) {
        return new User(entity.getDni(),entity.getName());
    }

    static UserEntity mapToEntityDomain(User user) {
        return new UserEntity(user.getId(), user.getName());
    }
    static List<User> mapToDomainList(List<UserEntity> entities){
        List<User> list = new ArrayList<>();

        for(UserEntity entity: entities){
            list.add(mapToDomainEntity(entity));
        }
        return list;
    }
}
