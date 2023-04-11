package com.example.sprinttaskee2.servlet;

import com.example.sprinttaskee2.dao.ItemDao;
import com.example.sprinttaskee2.dao.UserDao;
import com.example.sprinttaskee2.entity.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    private final ItemDao itemDao = ItemDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = itemDao.findAll();
        request.setAttribute("items", items);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
