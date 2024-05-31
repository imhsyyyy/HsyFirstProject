package com.fdzc.hsyfirstproject.Service;

import com.fdzc.hsyfirstproject.Entity.Department;

import com.fdzc.hsyfirstproject.Mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl  implements DepartmentService{
    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public boolean addDepartment(Department department) {
        departmentMapper.addDepartment(department);
        return false;
    }

    @Override
    public boolean deleteDepartment(int id) {
        departmentMapper.deleteDepartmentById(id);
        return false;
    }

    @Override
    public void batchDeleteDepartment(List<Integer> ids) {
        departmentMapper.batchDeleteDepartments(ids);
    }

    @Override
    public boolean updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
        return false;
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentMapper.getDepartmentById(id);
    }


    @Override
    public List<Department> getAllDepartments(List<Integer> list) {
        return  departmentMapper.getAllDepartments();
    }

    @Override
    public Department findDeptUsers(Integer id) {
        return departmentMapper.findDeptUsers(id);
    }


}

