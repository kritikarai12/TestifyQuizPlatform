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

@WebServlet("/viewResults")
public class ViewResultsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM results";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            response.getWriter().println("<h2>Results</h2>");

            while (rs.next()) {

                String username = rs.getString("username");
                int score = rs.getInt("score");

                response.getWriter().println(
                        username + " : " + score + "<br>"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}