package dao.daoImpl;

import bean.Province;
import dao.ProvinceDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProvinceDaoImpl implements ProvinceDao{

    @Override
    public List<Province> getProvince() {
        ResourceBundle bundle = ResourceBundle.getBundle("dao.daoImpl.jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String username = bundle.getString("username");
        String password = bundle.getString("password");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Province> listProvince = new ArrayList<>();

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url,username,password);
            String sql = "select * from t_province";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                Province province = new Province(code,name);
                listProvince.add(province);
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


        return listProvince;
    }

}
