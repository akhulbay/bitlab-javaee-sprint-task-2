package com.example.sprinttaskee2.servlet;

import com.example.sprinttaskee2.dao.UserDao;
import com.example.sprinttaskee2.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserDao userDao = UserDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDao.findByPasswordAndEmail(password, email).orElse(null);
        if (user != null) {
            response.sendRedirect("/userProfile");
        } else {
            response.sendRedirect("/login?fail");
        }
    }
}
