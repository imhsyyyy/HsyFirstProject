package com.fdzc.hsyfirstproject.Service;

import com.fdzc.hsyfirstproject.Entity.Department;

import java.util.List;

public interface DepartmentService {
    boolean addDepartment(Department department);
    boolean deleteDepartment(int id);
    void batchDeleteDepartment(List<Integer> ids);
    boolean updateDepartment(Department department);
    Department getDepartmentById(int id);
    List<Department> getAllDepartments(List<Integer> list);
    // 多表查询：部门和用户信息
    Department findDeptUsers(Integer id);

}
