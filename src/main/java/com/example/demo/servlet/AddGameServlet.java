package com.example.demo.servlet;

import com.example.demo.dao.Dao;
import com.example.demo.dao.DaoFactory;
import com.example.demo.model.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/games/add")
public class AddGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/add-game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String name = request.getParameter("gameName");
        String description = request.getParameter("gameDescription");

        Game game = new Game(name, description);
        Dao<Game> gameDao = DaoFactory.getGameDao();
        gameDao.save(game);

        resp.sendRedirect(request.getContextPath() + "/games");
    }
}
