package com.tech1.task.service.impl;


import com.tech1.task.dao.UserDao;
import com.tech1.task.dto.UserDto;
import com.tech1.task.dto.UserNamesDto;
import com.tech1.task.entity.User;
import com.tech1.task.exception.UserNotFoundException;
import com.tech1.task.form.UserForm;
import com.tech1.task.service.TokenService;
import com.tech1.task.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserDao userDao, ModelMapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        if (userDao.findById(id).isPresent()) {
            return userDao.findById(id).get();
        }
        throw new UserNotFoundException();
    }

    @Override
    public List<UserDto> getUsersWhereAgeIsGrater(int age) {

        return userDao.findByAgeGreaterThan(age)
                .stream()
                .map(x -> modelMapper.map(x, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserNamesDto getUsersWithArticles() {
        return new UserNamesDto(userDao.getUserNames());
    }

    @Override
    public void saveUser(UserForm userForm) {
        User user = modelMapper.map(userForm, User.class);
        userDao.save(user);
    }

    @Override
    public User getUserByLogin(String login) throws UserNotFoundException {
        if (userDao.findByLogin(login).isPresent()) {
            return userDao.findByLogin(login).get();
        }
        throw new UserNotFoundException();
    }
}

