package com.example.wushendemo.dao;


import com.example.wushendemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User find(String username);
    List<User> list();
    int insert(User user);
    int delete(int id);
    int update(User user);
}
