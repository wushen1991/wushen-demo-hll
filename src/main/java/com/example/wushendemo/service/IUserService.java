package com.example.wushendemo.service;

import com.example.wushendemo.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService {

     User findByUsername(String username);

     List<User> listUser();

     int insertUser(User user);


     int updateUser(User user);


     int delete(int id);

     int  errorUserOne(User user);


}
