package service.serviceImpl;

import bean.Dept;
import dao.DeptDao;
import dao.daoImpl.DeptDaoImpl;
import service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService{
    @Override
    public List<Dept> getDept(String deptno) {
        DeptDao deptDao = new DeptDaoImpl();
        List<Dept> listDept = deptDao.getDept(deptno);
        return listDept;
    }
}
