package com.example.wushendemo.service;

import com.example.wushendemo.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface IUserService {

     User findByUsername(String username);

     List<User> listUser();

     int insertUser(User user);


     int updateUser(User user);


     int delete(int id);

     int  insertUserOne(User user);

     int insertUserTwo(User user);

     int insertUserNoExc(User user);

     int creatUserErrorBack(User user) throws IOException;

     int createUserAB1(User user);

     int createUserAB2(User user);


}
