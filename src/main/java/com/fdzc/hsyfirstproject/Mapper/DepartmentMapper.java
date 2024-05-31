package com.fdzc.hsyfirstproject.Mapper;

import com.fdzc.hsyfirstproject.Entity.Department;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DepartmentMapper {
    // 部门表增加
    void addDepartment(Department department);

    // 删除部门（单个）
    int deleteDepartmentById(int id);

    // 批量删除部门
    void batchDeleteDepartments(List<Integer> ids);

    // 修改部门
    void updateDepartment(Department department);

    // 查询部门
    Department getDepartmentById(int id);

    // 查询所有部门
    List<Department> getAllDepartments();

    // 多表查询：部门和用户信息
    Department findDeptUsers(Integer id);
}

