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

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String answer = request.getParameter("q1");

        int score = 0;

        if ("A".equals(answer)) {
            score = 1;
        }

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO results(username, score) VALUES(?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            String username = (String) request.getSession().getAttribute("username");

            ps.setString(1, username);
            ps.setInt(2, score);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.getWriter().println("<h2>Your Score: " + score + "/1</h2>");

    }
}