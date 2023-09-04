package com.dynamicQuery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dynamicQuery.model.Employee;

public interface EmpRepository extends JpaRepository<Employee,Integer> {

}
