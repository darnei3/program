package ru.darnei.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import ru.darnei.study.model.User;
import ru.darnei.study.service.UserService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
@Api("Контрлллер для управления данными User")
public class UserController {


    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Получение списка всех записей", response = List.class)
    public ArrayList<User> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Получение записи", response = User.class)
    public User getUser(
            @ApiParam(value = "Укажите id необходимого вам User", required = true) @PathVariable Integer userId){
        return service.getUser(userId);
    }


    @PostMapping
    @ApiOperation(value = "Создание новой записи", response = User.class)
    public User createUser(
            @ApiParam("Введите параметры добавляемого user(a)")@RequestBody User user){
        service.saveUser(user);
        return user;
    }

    @DeleteMapping("/{userId}")
    @ApiOperation("Удаление записи")
    public void deleteUser(
            @ApiParam("Введите id user(a) которого вы хотите удалить")@PathVariable Integer userId){
        service.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    @ApiOperation(value = "Обновление записи", response = User.class)
    public User updateUser(
            @ApiParam("Введите id user(а) данные котрого вы хотите изменить")@PathVariable Integer userId,
            @ApiParam("Введите параметры для изменения user(a)")@RequestBody User user){
        service.updateUser(userId,user);
        return service.getUser(userId);
    }



}