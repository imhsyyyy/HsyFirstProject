package com.fdzc.hsyfirstproject.Service;

import com.fdzc.hsyfirstproject.Entity.User;
import java.util.List;
import java.util.Map;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    void batchDeleteUser(List<Integer> ids);
    void updateUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    List<Map<String, Object>> findUserDept();

    // 批量添加用户
    void batchAddUsers(List<User> users);
}
