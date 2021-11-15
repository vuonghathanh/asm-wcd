package com.demo.servlet;

import com.demo.dao.UserDao;
import com.demo.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> userList = userDao.findUser(username);
        User newUser = new User();
        if (userList.size() > 0) {
            for (User user : userList) {
                newUser.setUsername(user.getUsername());
                newUser.setPassword(user.getPassword());
            }
            if (newUser.getUsername().equalsIgnoreCase(username) && newUser.getPassword().equalsIgnoreCase(password)) {
                response.sendRedirect("ProductServlet");
            }
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
