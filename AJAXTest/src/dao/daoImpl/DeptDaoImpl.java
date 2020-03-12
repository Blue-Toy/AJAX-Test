package dao.daoImpl;

import bean.City;
import bean.Dept;
import dao.DeptDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DeptDaoImpl implements DeptDao{
    @Override
    public List<Dept> getDept(String deptno) {

        int deptno1 = Integer.parseInt(deptno);

        ResourceBundle bundle = ResourceBundle.getBundle("dao.daoImpl.jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String username = bundle.getString("username");
        String password = bundle.getString("password");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Dept> listDept = new ArrayList<>();

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url,username,password);
            String sql = "SELECT d.dname,e.job,count(e.ENAME) no FROM dept d JOIN emp e on e.deptno=d.deptno WHERE d.deptno=? group by job";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,deptno1);
            rs = ps.executeQuery();
            while (rs.next()){
                String dname = rs.getString("dname");
                String job = rs.getString("job");
                int no = rs.getInt("no");
                Dept dept = new Dept(dname,job,no);
                listDept.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return listDept;
    }
}
