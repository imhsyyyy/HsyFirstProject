package com.fdzc.hsyfirstproject.Controller;

import com.fdzc.hsyfirstproject.Entity.Department;
import com.fdzc.hsyfirstproject.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
    }

    @DeleteMapping("/batchDelete")
    public void batchDeleteDepartment(@RequestBody List<Integer> ids) {
        departmentService.batchDeleteDepartment(ids);
    }

    @PutMapping("/update")
    public void updateDepartment(@RequestBody Department department) {
        departmentService.updateDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        List<Integer> list = null;
        return departmentService.getAllDepartments(list);
    }

    @GetMapping("/dept/{id}")
    public Department findDeptUser(@PathVariable Integer id){
        return departmentService.findDeptUsers(id);
    }
}