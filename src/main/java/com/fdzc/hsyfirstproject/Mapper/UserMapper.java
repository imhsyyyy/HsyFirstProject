package com.fdzc.hsyfirstproject.Mapper;

import com.fdzc.hsyfirstproject.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    //添加
    void addUser(User user);
    //根据id删除
    Integer deleteUser(int id);
    //批量删除
    Integer batchDeleteUser(List<Integer> ids);
    //更新
    Integer updateUser(User user);
    //查询
    User getUserById(int id);
    //查询所有
    List<User> getAllUsers();
    //查询用户和部门信息
    List<Map<String, Object>> findUserDept();

    // 批量添加用户
    void batchAddUsers(List<User> users);
}