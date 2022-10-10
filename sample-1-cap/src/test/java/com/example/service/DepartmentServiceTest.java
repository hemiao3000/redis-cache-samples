package com.example.service;

import com.example.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Resource
    private DepartmentService service;

    @Test
    void getDepartmentById() {
        Department dept = service.getDepartmentById(5L);
        System.out.println(dept);
    }

    @Test
    void addDepartment() {
        service.addDepartment("hello", "world");
    }

    @Test
    void updateDepartment() {
        service.updateDepartment(5L, "HELLO", "WORLD");
    }

    @Test
    void deleteDepartment() {
    }
}