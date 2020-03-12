package service.serviceImpl;

import bean.Province;
import dao.ProvinceDao;
import dao.daoImpl.ProvinceDaoImpl;
import service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService{

    @Override
    public List<Province> getProvince() {

        ProvinceDao provinceDao = new ProvinceDaoImpl();
        List<Province> listProvince = provinceDao.getProvince();

        return listProvince;

    }

}
