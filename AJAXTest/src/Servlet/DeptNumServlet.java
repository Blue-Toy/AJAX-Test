package Servlet;

import bean.Dept;
import net.sf.json.JSONArray;
import service.DeptService;
import service.serviceImpl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeptNumServlet")
public class DeptNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String deptno = request.getParameter("deptno");
        //System.out.println(deptno);
        DeptService deptService = new DeptServiceImpl();
        List<Dept> listDept = deptService.getDept(deptno);
        JSONArray jsonArray = JSONArray.fromObject(listDept);
        System.out.println(jsonArray);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(jsonArray);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
