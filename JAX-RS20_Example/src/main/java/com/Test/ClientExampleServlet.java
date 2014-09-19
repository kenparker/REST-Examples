package com.Test;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author angelomaggioni
 */
@WebServlet(value = "/user")
public class ClientExampleServlet extends HttpServlet
{
    @EJB
    GithubClient client;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("start servelet");
        resp.getWriter().print(client.findUserByUsername(req.getParameter("username")));
    }
    
}
