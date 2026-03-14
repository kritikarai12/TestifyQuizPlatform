package com.testify.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testify.util.DBConnection;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM students WHERE username=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                request.getSession().setAttribute("username", username);

                response.sendRedirect("quiz.html");

            

            } else {

                response.getWriter().println("<h2>Invalid Username or Password</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
