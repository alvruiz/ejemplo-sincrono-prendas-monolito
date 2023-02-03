package com.hiberus.monolith.infrastructure.adapter.in.web.controller;


import com.hiberus.monolith.domain.model.Size;
import com.hiberus.monolith.infrastructure.DTO.GarmentDTO;
import com.hiberus.monolith.infrastructure.DTO.GarmentIdentifierDTO;
import com.hiberus.monolith.infrastructure.adapter.out.persistence.UserDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;

@RestController
public interface MonolithController {

    @ApiOperation(value="Crear una prenda")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creada con exito"),
            @ApiResponse(code = 400, message = "Ya existe"),
            @ApiResponse(code = 400, message = "Error al crear")
    })
    @PostMapping(value="/clothing", produces = "application/json")
    ResponseEntity<String> createGarment(@RequestBody GarmentDTO garment);

    @ApiOperation(value="Eliminar una prenda")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Eliminada con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error al eliminar")
    })
    @DeleteMapping(value="/clothing", produces = "application/json")
    ResponseEntity<String> deleteGarment(@RequestBody GarmentIdentifierDTO garment);

    @ApiOperation(value="Obtener todas las prendas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenidas con exito"),
            @ApiResponse(code = 400, message = "Error al obtener"),
    })
    @GetMapping(value="/clothing", produces = "application/json")
    ResponseEntity<String> getClothing();

    @ApiOperation(value="Obtener prenda por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenidas con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error obteniendo prenda")

    })
    @GetMapping(value="/clothing/garment", produces = "application/json")
    ResponseEntity<String> getClothing(@QueryParam("name") String name, @QueryParam("size") Size size);

    @ApiOperation(value="Actualizar cantidad de prenda")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Actualizado con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error obteniendo prenda")

    })
    @PutMapping(value="/clothing/upgrade_quantity", produces = "application/json")
    ResponseEntity<String> upgradeQuantity(@RequestBody GarmentIdentifierDTO garmentIdentifierDTO);

    @ApiOperation(value="Actualizar cantidad de prenda")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Actualizado con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error"),
            @ApiResponse(code = 400, message = "Cantidad insuficiente")

    })
    @PutMapping(value="/clothing/downgrade_quantity", produces = "application/json")
    ResponseEntity<String> downgradeQuantity(@RequestBody GarmentIdentifierDTO garmentIdentifierDTO);

    @ApiOperation(value = "Crear un usuario")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creado con exito"),
            @ApiResponse(code = 400, message = "Ya existe usuario"),
            @ApiResponse(code = 400, message = "Error al crear")
    })
    @PostMapping(value = "/users", produces = "application/json")
    ResponseEntity<String> createUser(@RequestBody UserDTO user);

    @ApiOperation(value = "Eliminar un usuario")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Eliminado con exito"),
            @ApiResponse(code = 200, message = "No encontrado el usuario"),
            @ApiResponse(code = 400, message = "Error al eliminar"),
    })
    @DeleteMapping(value = "/users/{id}", produces = "application/json")
    ResponseEntity<String> deleteUser(@RequestParam String id);

    @ApiOperation(value = "Obtener todos los usuarios")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenidas con exito"),
            @ApiResponse(code = 400, message = "Error"),
    })
    @GetMapping(value = "/users", produces = "application/json")
    ResponseEntity<String> getUsers();

    @ApiOperation(value = "Obtener usuario por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenidas con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error obteniendo usuario")

    })
    @GetMapping(value = "/users/{id}", produces = "application/json")
    ResponseEntity<String> getUserById(@RequestParam String id);

    @ApiOperation(value = "Actualizar nombre de usuario")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Actualizado con exito"),
            @ApiResponse(code = 404, message = "No existe"),
            @ApiResponse(code = 400, message = "Error al actualizar")

    })
    @PutMapping(value = "/users", produces = "application/json")
    ResponseEntity<String> updateName(@RequestBody UserDTO userDTO);
}
