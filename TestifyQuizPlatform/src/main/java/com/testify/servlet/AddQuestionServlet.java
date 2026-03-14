package com.testify.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.testify.util.DBConnection;

@WebServlet("/addQuestion")
public class AddQuestionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String q = request.getParameter("question");
        String op1 = request.getParameter("op1");
        String op2 = request.getParameter("op2");
        String op3 = request.getParameter("op3");
        String op4 = request.getParameter("op4");
        String ans = request.getParameter("answer");

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
            "INSERT INTO questions(question, option1, option2, option3, option4, answer) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, q);
            ps.setString(2, op1);
            ps.setString(3, op2);
            ps.setString(4, op3);
            ps.setString(5, op4);
            ps.setString(6, ans);

            ps.executeUpdate();

            response.getWriter().println("Question Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}