package com.ibs.training.fullstack.resourcemangement.service;

import com.ibs.training.fullstack.resourcemangement.model.Employee;
import com.ibs.training.fullstack.resourcemangement.repository.EmployeeRepository;
import com.ibs.training.fullstack.resourcemangement.view.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseView<Employee> getById(String id) {
        LOGGER.info("Fetching Employee Id :{}", id);
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.isPresent() ?
                new ResponseView<>(employee.get()) :
                new ResponseView<>("No Employee Found for id:" + id);
    }

    public ResponseView<Employee> save(Employee employee) {
        LOGGER.info("Fetching Employee Name :{}", employee.getName());
        Employee emp = employeeRepository.save(employee);
        return new ResponseView<>(emp);
    }

    public ResponseView<List<Employee>> fetchAll() {
        LOGGER.info("Fetching All Employees");
        List<Employee> employees = employeeRepository.findAll();
        return employees.isEmpty() ? new ResponseView<>("No Employee Records found!") :
                new ResponseView<>(employees);

    }

    public ResponseView deleteById(String id) {
        LOGGER.info("Deleting Employee Id :{}", id);
        employeeRepository.deleteById(id);
        return new ResponseView<>("Employee deleted successfully, id:" + id);
    }

    public ResponseView update(Employee employee) {
        ResponseView result = new ResponseView<>("No Employee Found for id:" + employee.getId());
        LOGGER.info("Updating Employee Id :{} name: {}", employee.getId(), employee.getName());

        Optional<Employee> user = employeeRepository.findById(employee.getId());
        if(user.isPresent()) {
            result = new ResponseView<>(employeeRepository.save(employee));
        }

        return result;
    }

}

