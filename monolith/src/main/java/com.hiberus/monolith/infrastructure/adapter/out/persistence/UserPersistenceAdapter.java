package com.hiberus.monolith.infrastructure.adapter.out.persistence;

import com.hiberus.monolith.domain.model.User;
import com.hiberus.monolith.domain.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserPersistenceAdapter implements UserPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public boolean createUser(User user) {
        try{
            UserEntity entity = UserMapper.mapToEntityDomain(user);
            userRepository.save(entity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteUser(String dni) {
        try{
            userRepository.deleteByDni(dni);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<User> getUsers() {
        try{
            List<UserEntity> list = userRepository.findAll();
            return UserMapper.mapToDomainList(list);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public User getUser(String id) {
        try{
            UserEntity entity = userRepository.findByDni(id);
            return UserMapper.mapToDomainEntity(entity);
        }catch (Exception e){
            return null;
        }
    }
}
