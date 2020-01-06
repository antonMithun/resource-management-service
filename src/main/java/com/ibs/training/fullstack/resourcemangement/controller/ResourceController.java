package com.ibs.training.fullstack.resourcemangement.controller;

import com.ibs.training.fullstack.resourcemangement.model.Employee;
import com.ibs.training.fullstack.resourcemangement.service.EmployeeService;
import com.ibs.training.fullstack.resourcemangement.view.ResponseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class ResourceController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/{id}")
    public ResponseView getEmployee(@PathVariable(value = "id") String id) {
        return employeeService.getById(id);
    }

    @GetMapping(value = "/listAll")
    public ResponseView getEmployee() {
        return employeeService.fetchAll();
    }

    @PostMapping(value = "/save")
    public ResponseView<Employee> saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseView<Employee> deleteEmployee(@PathVariable(value = "id") String id) {
        return employeeService.deleteById(id);
    }

    @PutMapping(value = "/update")
    public ResponseView<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

}
