package com.example.service;

import com.example.dao.DepartmentMapper;
import com.example.entity.Department;
import com.example.redis.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.bytecode.DeprecatedAttribute;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentMapper mysqlDao;
    private final DepartmentRepository redisDao;

    public Department getDepartmentById(Long id) {
        Department dept = null;

        // redis 中有，从 redis 中读取，返回。
        dept = redisDao.findById(id).orElse(null);
        if (dept != null) {
            return dept;
        }

        // mysql 中也没有，抛出空指针异常
        dept = mysqlDao.selectById(id);
        if (dept == null)
            throw new NullPointerException();

        // mysql 中有，但是 redis 中没有。存 redis ，再返回。
        redisDao.save(dept);
        return dept;
    }

    public void addDepartment(String name, String location) {
        Department dept = new Department(null, name, location);
        mysqlDao.insert(dept);
    }

    public void updateDepartment(Long id, String newName, String newLocation) {
        Department dept = new Department(id, newName, newLocation);

        // 第一次删除 redis
        redisDao.deleteById(id);
        // 更新 mysql
        mysqlDao.updateById(dept);
        // 第二次删除 redis
        redisDao.deleteById(id);
    }

    public void deleteDepartment(Long id) {
        // 第一次删除 redis
        redisDao.deleteById(id);
        // 删除 mysql
        mysqlDao.deleteById(id);
        // 第二次删除 redis
        redisDao.deleteById(id);
    }

}
