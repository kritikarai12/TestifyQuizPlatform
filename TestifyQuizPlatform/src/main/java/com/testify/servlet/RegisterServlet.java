package com.testify.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testify.util.DBConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        try {

            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO students(name,username,password) VALUES(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.getWriter().println("<h2>Registration Successful!</h2>");
            } else {
                response.getWriter().println("<h2>Registration Failed!</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error occurred</h2>");
        }
    }
}