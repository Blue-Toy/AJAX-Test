package dao;

import bean.City;

import java.util.List;

public interface CityDao {
    List<City> getCity(String code);
}
