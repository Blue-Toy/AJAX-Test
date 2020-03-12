package dao;

import bean.Dept;

import java.util.List;

public interface DeptDao {
    List<Dept> getDept(String deptno);
}
