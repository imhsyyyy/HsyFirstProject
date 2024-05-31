package com.fdzc.hsyfirstproject;

import com.fdzc.hsyfirstproject.Entity.Department;
import com.fdzc.hsyfirstproject.Entity.User;
import com.fdzc.hsyfirstproject.Mapper.DepartmentMapper;
import com.fdzc.hsyfirstproject.Mapper.UserMapper;
import com.fdzc.hsyfirstproject.Service.DepartmentService;
import com.fdzc.hsyfirstproject.Service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;

@SpringBootTest
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService deptService;

    private static SqlSession getSqlSession(){
        //读取MyBaits的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory对象(通过创建SqlSessionFactoryBuilder来进行获取)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建sqlSession对象（MyBatis的操作数据库的会话对象，通过此对象可以获取SQL语句，并执行）
        //注意：openSession对象默认是不会进行自动的事务提交的,所以我们如果想做DML操作并且自动事务提交，需要加上true参数，默认为false
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }



    @Test
    public void findUserAllTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getAllUsers();
        users.forEach(user-> System.out.println(user));
    }

    @Test
    public void findUserByIdTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(20);
        System.out.println(user);
    }


    @Test
    public void deleteTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer num = userMapper.deleteUser(10);
        System.out.println(num);
    }

    @Test
    public void deleteUsersTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(21);
        Integer num = userMapper.batchDeleteUser(list);
        System.out.println(num);
    }

    @Test
    public void addUserTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUser_name("zhaoliu");
        user.setBirthday(20240512);
        user.setPassword("hello");
        user.setGender(1);
        user.setDept_id(3);
        userMapper.addUser(user);
        System.out.println(user);
    }

    @Test
    public void addUsersTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();

        user1.setUser_name("add1");
        user1.setBirthday(20240512);
        user1.setPassword("add1");
        user1.setGender(1);
        user1.setDept_id(4);

        user2.setUser_name("add2");
        user2.setBirthday(20240512);
        user2.setPassword("add2");
        user2.setGender(2);
        user2.setDept_id(2);

        users.add(user1);
        users.add(user2);

        userMapper.batchAddUsers(users);
    }

//    @Test
//    public void updateUserTest(){
//        SqlSession sqlSession = MyBatisDemo.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//        User user = userMapper.selectById(24);
////        System.out.println(user);
//        user.setPassword("1234567");
//        userMapper.update(user);
////        System.out.println(user);
//    }

    @Test
    public void findUserDeptTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userDept = userMapper.getUserById(26);
        System.out.println(userDept);

    }

    @Test
    public void findAllUserDeptTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getAllUsers();
        list.forEach(user-> System.out.println(user));
    }

    /**
     * DeptTestMethods
     */
    @Test
    public void findDeptByIdTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = deptMapper.getDepartmentById(1);
        System.out.println(department);
    }

    @Test
    public void findAllDeptTest(){
        SqlSession sqlSession = TestController.getSqlSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departments = deptMapper.getAllDepartments();
        departments.forEach(department -> System.out.println(department));
    }


    @Test
    public void addDepartmentTest() {
        SqlSession sqlSession = TestController.getSqlSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = new Department();
        department.setDept_name("后勤部");
        department.setAddress("208");
        department.setDescription("后勤");

        deptMapper.addDepartment(department);
    }

    // @Test
    // public void addDepartmentsTest(){
    //     SqlSession sqlSession = TestController.getSqlSession();
    //     DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
    //
    //     List<Department> list = new ArrayList<>();
    //     Department department1 = new Department();
    //     department1.setDept_name("教学部");
    //     department1.setAddress("206");
    //     department1.setDescription("教书");
    //
    //     Department department2 = new Department();
    //     department2.setDept_name("住宿");
    //     department2.setAddress("207");
    //     department2.setDescription("睡觉");
    //
    //     list.add(department1);
    //     list.add(department2);
    //     deptMapper.addDepartment(list);
    // }

    @Test
    public void deleteDeptTest() {
        SqlSession sqlSession = TestController.getSqlSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
        int i = deptMapper.deleteDepartmentById(12);
        System.out.println(i);
    }

    @Test
    public void deleteDeptsTest() {
        SqlSession sqlSession = TestController.getSqlSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        deptMapper.batchDeleteDepartments(list);
    }

//    @Test
//    public void upadateDept(){
//        SqlSession sqlSession = MyBatisDemo.getSqlSession();
//        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
//        Department department = deptMapper.selDept(13);
//        department.setDescription("饿了");
//        deptMapper.updateDeptSel(department);
//    }

    @Test
    public void findDeptUserTest(){
        try {
            Department deptUser = deptService.findDeptUsers(1);
            System.out.println(deptUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findDeptUserAllTest(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        try {
            List<Department> deptUserAll = deptService.getAllDepartments(list);
            deptUserAll.forEach(deptUser -> System.out.println(deptUser));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
