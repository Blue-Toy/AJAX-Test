package service.serviceImpl;

import bean.City;
import dao.CityDao;
import dao.daoImpl.CityDaoImpl;
import service.CityService;

import java.util.List;

public class CityServiceImpl implements CityService{

    @Override
    public List<City> getCity(String code) {
        CityDao cityDao = new CityDaoImpl();
        List<City> listCity = cityDao.getCity(code);

        return listCity;

    }

}
