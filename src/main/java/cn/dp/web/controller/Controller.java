package cn.dp.web.controller;

import cn.dp.domain.Customer;
import cn.dp.exception.IdIsNullException;
import cn.dp.service.BussinessService;
import cn.dp.service.impl.BussinessServiceImpl;
import cn.dp.utils.FillBeanUtil;
import cn.dp.web.bean.CustomerFormBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Controller extends HttpServlet {
    BussinessService bs = new BussinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoding = "UTF-8";
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=" + encoding);

        String op = request.getParameter("op");
        //根据参数分发
        if (op.equals("showAllCustomers")) {
            showAllConsumers(request, response);
        } else if (op.equals("addCustomers")) {
            addCustomers(request, response);
        } else if (op.equals("editUI")) {
            editUI(request, response);
        } else if (op.equals("editCustomer")) {
            editCustomer(request, response);
        } else if (op.equals("delOne")) {
            delOne(request, response);
        } else if (op.equals("delMulti")) {
            delMulti(request, response);
        }
    }

    //删除多个记录
    private void delMulti(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids");
        if (ids != null || ids.length > 0) {
            for(String id : ids){
                bs.deleteCustomer(Integer.parseInt(id));
            }
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    //删除一个记录
    private void delOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        bs.deleteCustomer(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    //修改用户信息
    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerFormBean cfb = FillBeanUtil.fillBean(request, CustomerFormBean.class);
        //验证表单填写,如果不通过就回显
        if (!cfb.isValidate()) {
            request.setAttribute("formBean", cfb);
            request.getRequestDispatcher("/addCustomers.jsp").forward(request, response);
        }
        //验证通过,将formbean转换成customer
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        Customer customer = new Customer();
        try {
            BeanUtils.copyProperties(customer, cfb);
        } catch (Exception e) {
            response.getWriter().print("服务器忙,请稍后");
            e.printStackTrace();
            return;
        }
        //手动处理hobby
        String[] hobbies = cfb.getHobbies();
        if (hobbies != null && hobbies.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hobbies.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(hobbies[i]);
            }
            customer.setHobby(sb.toString());
        }
        try {
            bs.updateCustomer(customer);
        } catch (IdIsNullException e) {
            throw new RuntimeException("用户ID丢失");
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");


    }

    //修改用户信息
    private void editUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String webid = request.getParameter("id");
        Integer id = Integer.parseInt(webid);
        Customer c = bs.findCustomerById(id);
        request.setAttribute("c", c);
        request.getRequestDispatcher("/editCustomers.jsp").forward(request, response);
    }

    //添加用户
    private void addCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerFormBean cfb = FillBeanUtil.fillBean(request, CustomerFormBean.class);
        //验证表单填写,如果不通过就回显
        if (!cfb.isValidate()) {
            request.setAttribute("formBean", cfb);
            request.getRequestDispatcher("/addCustomers.jsp").forward(request, response);
        }
        //验证通过,将formbean转换成customer
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        Customer customer = new Customer();
        try {
            BeanUtils.copyProperties(customer, cfb);
        } catch (Exception e) {
            response.getWriter().print("服务器忙,请稍后");
            e.printStackTrace();
            return;
        }
        //手动处理hobby
        String[] hobbies = cfb.getHobbies();
        if (hobbies != null && hobbies.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hobbies.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(hobbies[i]);
            }
            customer.setHobby(sb.toString());
        }
        bs.addCustomer(customer);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    //显示所有用户信息
    private void showAllConsumers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> cos = bs.findAllCustomers();
        request.setAttribute("co", cos);
        request.getRequestDispatcher("/listCustomers.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
