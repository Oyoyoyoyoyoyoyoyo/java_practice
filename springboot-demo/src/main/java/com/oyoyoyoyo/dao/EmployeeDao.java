package com.oyoyoyoyo.dao;

import com.oyoyoyoyo.pojo.Department;
import com.oyoyoyoyo.pojo.Employee;
import org.apache.tomcat.util.security.Escape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Date:2021/1/14
 * Decription:<员工Dao>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Repository
public class EmployeeDao {
    //    模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", "1645590975@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "2645590975@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "3645590975@qq.com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "4645590975@qq.com", 1, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "5645590975@qq.com", 0, new Department(105, "后勤部")));
    }

    //    主键自增
    private static Integer initId = 1006;

    /**
     * 增加员工
     *
     * @param employee
     */
    private void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    /**
     * 查询全部员工的信息
     *
     * @return
     */
    public Collection<Employee> getAll() {
        return employees.values();
    }

    /**
     * 通过id查询员工
     *
     * @param id
     * @return
     */
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    /**
     * 删除员工
     *
     * @param id
     */
    public void delete(Integer id) {
        employees.remove(id);
    }
}
