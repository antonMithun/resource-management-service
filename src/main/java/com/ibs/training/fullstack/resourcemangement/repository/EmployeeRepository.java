package com.ibs.training.fullstack.resourcemangement.repository;

import com.ibs.training.fullstack.resourcemangement.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
