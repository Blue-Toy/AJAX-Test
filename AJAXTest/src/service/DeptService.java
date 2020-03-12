package service;

import bean.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> getDept(String deptno);
}
