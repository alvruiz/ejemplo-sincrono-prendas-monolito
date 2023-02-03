package com.hiberus.monolith.infrastructure.adapter.in.web.controller;

import com.google.gson.Gson;
import com.hiberus.monolith.domain.model.Size;

import com.hiberus.monolith.domain.model.Garment;
import com.hiberus.monolith.domain.model.User;
import com.hiberus.monolith.domain.ports.in.*;
import com.hiberus.monolith.infrastructure.DTO.GarmentDTO;
import com.hiberus.monolith.infrastructure.DTO.GarmentIdentifierDTO;
import com.hiberus.monolith.infrastructure.adapter.out.persistence.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MonolithControllerImpl implements MonolithController {

    public static final String DOESNT_EXIST = "Doesnt exist";
    private final CreateGarmentUseCase createGarmentUseCase;
    private final DeleteGarmentUseCase deleteGarmentUseCase;
    private final GetClothingUseCase getClothingUseCase;
    private final GetGarmentByIDUseCase getGarmentByIDUseCase;

    private final UpgradeDowngradeQuantityUseCase upgradeDowngradeQuantityUseCase;
    private Gson gson = new Gson();
    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final GetUserUseCase getUsersUseCase;
    private final GetUserByIDUseCase getUserByIDUseCase;

    private final UpdateNameUseCase updateNameUseCase;

    @Override
    public ResponseEntity<String> createGarment(GarmentDTO garmentDTO){
        Garment garment;
        try {
            garment = new Garment(garmentDTO.getName(),garmentDTO.getQuantity(),garmentDTO.getSize());
            if(getGarmentByIDUseCase.getGarment(garmentDTO.getName()+garmentDTO.getSize()) != null){
                return new ResponseEntity<>(gson.toJson("Already exists"), HttpStatus.NOT_FOUND);
            }
            createGarmentUseCase.createGarment(garment);
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(gson.toJson(garment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteGarment(GarmentIdentifierDTO garmentDTO){
        try {
            Garment garment = getGarmentByIDUseCase.getGarment(garmentDTO.getName()+garmentDTO.getSize());
            if(garment == null){
                return new ResponseEntity<>(gson.toJson("Not found"), HttpStatus.NOT_FOUND);
            }
            deleteGarmentUseCase.deleteGarment(garmentDTO.getName(),garmentDTO.getSize());
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(gson.toJson("Deleted "+garmentDTO.getName()+" Size: "+garmentDTO.getSize()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getClothing() {
        List<Garment> list;
        try {
            list = getClothingUseCase.getClothing();
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(gson.toJson(list), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getClothing(String name, Size size) {
        Garment garment;
        try {
            garment = getGarmentByIDUseCase.getGarment(name+size);
            if(garment == null){
                return new ResponseEntity<>(gson.toJson("Not found"), HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(garment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> upgradeQuantity(GarmentIdentifierDTO garmentIdentifierDTO) {
        Garment garment;
        boolean succesfull;
        try {
            garment = getGarmentByIDUseCase.getGarment(garmentIdentifierDTO.getName()+garmentIdentifierDTO.getSize());
            if(garment == null){
                return new ResponseEntity<>(gson.toJson("Not found"), HttpStatus.NOT_FOUND);
            }
            succesfull = upgradeDowngradeQuantityUseCase.upgrade(garment);
            if(!succesfull){
                return new ResponseEntity<>(gson.toJson("Error upgrading"), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(garment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> downgradeQuantity(GarmentIdentifierDTO garmentIdentifierDTO) {
        Garment garment;
        boolean succesfull;
        try {
            garment = getGarmentByIDUseCase.getGarment(garmentIdentifierDTO.getName()+garmentIdentifierDTO.getSize());
            if(garment == null){
                return new ResponseEntity<>(gson.toJson("Not found"), HttpStatus.NOT_FOUND);
            }
            if(garment.getQuantity() == 0){
                return new ResponseEntity<>(gson.toJson("Not enough"), HttpStatus.BAD_REQUEST);
            }
            succesfull = upgradeDowngradeQuantityUseCase.downgrade(garment);
            if(!succesfull){
                return new ResponseEntity<>(gson.toJson("Error upgrading"), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(garment), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<String> createUser(UserDTO userDTO){
        User user;
        try {
            user = new User(userDTO.getDni(),userDTO.getName());
            if(getUserByIDUseCase.getUser(userDTO.getDni()) != null){
                return new ResponseEntity<>(gson.toJson("Already exists"), HttpStatus.NOT_FOUND);
            }
            createUserUseCase.createUser(user);
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(gson.toJson(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteUser(String id){
        try {
            User user = getUserByIDUseCase.getUser(id);
            if(user == null){
                return new ResponseEntity<>(gson.toJson("Not found"), HttpStatus.NOT_FOUND);
            }
            deleteUserUseCase.deleteUser(id);

        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(gson.toJson("Deleted "+id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getUsers() {
        List<User> list;
        try {
            list = getUsersUseCase.getUsers();
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(list), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getUserById(String id) {
        User user;
        try {
            user = getUserByIDUseCase.getUser(id);
            if(user == null){
                return new ResponseEntity<>(gson.toJson("Not found"), HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateName(UserDTO userDTO) {
        User user;
        boolean succesfull;
        try {
            user = getUserByIDUseCase.getUser(userDTO.getDni());
            if(user == null){
                return new ResponseEntity<>(gson.toJson("Not found"), HttpStatus.NOT_FOUND);
            }
            succesfull = updateNameUseCase.updateName(user,userDTO.getName());
            if(!succesfull){
                return new ResponseEntity<>(gson.toJson("Error updating"), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gson.toJson(user), HttpStatus.OK);
    }

}
