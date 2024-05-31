package com.fdzc.hsyfirstproject.Controller;

import com.fdzc.hsyfirstproject.Entity.User;
import com.fdzc.hsyfirstproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @DeleteMapping("/batchDelete")
    public void batchDeleteUser(@RequestBody List<Integer> ids) {
        userService.batchDeleteUser(ids);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 查询用户部门信息
    @GetMapping("/dept")
    public ResponseEntity<List<Map<String, Object>>> findUserDept() {
        List<Map<String, Object>> result = userService.findUserDept();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/batchAddUsers")
    public void batchAddUsers(@RequestBody List<User> users) {
        userService.batchAddUsers(users);
    }


}