package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = LoginServlet.URL)
public class LoginServlet extends HttpServlet {

    public static final String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect(GameListServlet.URL);
        } else {
            req.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (getServletContext().getAttribute("nbLoginHit") != null) {
            int hit = (int) getServletContext().getAttribute("nbLoginHit");
            getServletContext().setAttribute("nbLoginHit", ++hit);
        } else {
            getServletContext().setAttribute("nbLoginHit", 1);
        }

        if (username.equals("admin") && password.equals("qwerty")) {
            // Get existing session or create one if not exist
            HttpSession session = req.getSession(true);

            session.setAttribute("username", username);
            // Expiration after 30 minutes
            session.setMaxInactiveInterval(30 * 60);

            Cookie cookieU = new Cookie("username", username);
            resp.addCookie(cookieU);

            resp.sendRedirect(GameListServlet.URL);
        } else {
            req.setAttribute("loginFail", true);
            doGet(req, resp);
        }

    }
}
