package com.fdzc.hsyfirstproject;

import com.fdzc.hsyfirstproject.Controller.DepartmentController;
import com.fdzc.hsyfirstproject.Entity.Department;
import com.fdzc.hsyfirstproject.Service.DepartmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// public class TestLog4j {
//     private static final Logger logger = Logger.getLogger(TestLog4j.class);
//     public static void main(String[] args) {
//         logger.debug("This is a debug log.");
//         logger.info("This is an info log.");
//         logger.warn("This is a warn log.");
//         logger.error("This is an error log.");
//         logger.fatal("This is a fatal log.");
//     }
// }

@RestController
public class TestLog4j {
    private static final Logger logger = Logger.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departService;

    public List<Department> selAllDept()
    {   logger.info("前端传来的参数:" );
        List<Integer> list = null;
        return departService.getAllDepartments(list);
    }

    public int selDept(@RequestParam("id") Integer id)
    {   logger.info("前端传来的参数:" );
        return departService.getDepartmentById(id).getId(0);
    }

    @DeleteMapping("/dept/del")
    public String delDept(@RequestParam("id") Integer id)
    {   logger.info("前端传来的参数:" );
        if(departService.deleteDepartment(id))
        {
            return "删除成功";
        }
        return "删除失败";
    }

    // @PostMapping("/dept/del/sel")
    // public String delDeptSel(@RequestBody Department department)
    // {   logger.info("前端传来的参数:" );
    //     if(departService.batchDeleteDepartment(department))
    //     {
    //         return "删除成功";
    //     }
    //     return "删除失败";
    // }

    @PostMapping("/dept/add")
    public String delDept(@RequestBody Department department)
    {   logger.info("前端传来的参数:" );
        if(departService.addDepartment(department))
        {
            return "添加成功";
        }
        return "添加失败";
    }

    @PostMapping("/dept/update")
    public String updateDept(@RequestBody Department department)
    {   logger.info("前端传来的参数:" );
        if(departService.updateDepartment(department))
        {
            return "更新成功";
        }
        return "更新失败";
    }

    @GetMapping("/departments/dept/1")
    public Department selDeptUser(@RequestBody Department Department) {
        logger.info("前端传来的参数:" + Department.toString());
        System.out.println("----------->" + Department);
        return departService.findDeptUsers(1);
    }

}