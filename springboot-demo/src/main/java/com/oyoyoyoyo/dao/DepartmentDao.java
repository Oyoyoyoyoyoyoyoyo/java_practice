package com.oyoyoyoyo.dao;

import com.oyoyoyoyo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Date:2021/1/14
 * Decription:<部门dao>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "教研部"));
        departments.put(104, new Department(104, "运营部"));
        departments.put(105, new Department(105, "后勤部"));
        departments.put(106, new Department(106, "文艺部"));
    }

    /**
     * 获得所有部门信息
     *
     * @return
     */
    public Collection<Department> getDepartment() {
        return departments.values();
    }

    /**
     * 通过id获得部门信息
     *
     * @param id
     * @return
     */
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
