package Servlet;


import bean.City;
import net.sf.json.JSONArray;
import service.CityService;
import service.serviceImpl.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "CityServlet")
public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        //System.out.println(code);
        CityService cityService = new CityServiceImpl();
        List<City> listCity = cityService.getCity(code);
        JSONArray jsonArray = JSONArray.fromObject(listCity);
        System.out.println(jsonArray);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(jsonArray);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
