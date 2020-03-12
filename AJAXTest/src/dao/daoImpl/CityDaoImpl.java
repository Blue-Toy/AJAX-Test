package dao.daoImpl;

import bean.City;
import bean.Province;
import dao.CityDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CityDaoImpl implements CityDao{

    @Override
    public List<City> getCity(String code) {
        ResourceBundle bundle = ResourceBundle.getBundle("dao.daoImpl.jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String username = bundle.getString("username");
        String password = bundle.getString("password");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<City> listCity = new ArrayList<>();

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url,username,password);
            String sql = "select code,name from t_city where pcode=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,code);
            rs = ps.executeQuery();
            while (rs.next()){
                int code1 = rs.getInt("code");
                String name = rs.getString("name");
                City city = new City(code1,name);
                listCity.add(city);
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

        return listCity;

    }
}
