package com.fdzc.hsyfirstproject.Service;

import com.fdzc.hsyfirstproject.Entity.User;
import com.fdzc.hsyfirstproject.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void batchDeleteUser(List<Integer> ids) {
        userMapper.batchDeleteUser(ids);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public List<Map<String, Object>> findUserDept() {
        return userMapper.findUserDept();
    }

    @Override
    public void batchAddUsers(List<User> users) {
        userMapper.batchAddUsers(users);
    }
}
