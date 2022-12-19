package com.example.demo.servlet;

import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.GameDao;
import com.example.demo.model.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = GameListServlet.URL)
public class GameListServlet extends HttpServlet {

    public static final String URL = "/games";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameDao dao = DaoFactory.getGameDao();
        List<Game> gameList = dao.getAll();

        req.setAttribute("games", gameList);

        req.getRequestDispatcher("/WEB-INF/game-list.jsp").forward(req, resp);
    }

}
