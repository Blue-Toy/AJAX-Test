package Servlet;



import bean.Province;
import net.sf.json.JSONArray;
import service.ProvinceService;
import service.serviceImpl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ServletTest")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String code = request.getParameter("code");
        System.out.println(code);*/

        ProvinceService provinceService = new ProvinceServiceImpl();
        List<Province> listProvince = provinceService.getProvince();


        JSONArray jsonArray = JSONArray.fromObject(listProvince);
        System.out.println(jsonArray);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(jsonArray);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
