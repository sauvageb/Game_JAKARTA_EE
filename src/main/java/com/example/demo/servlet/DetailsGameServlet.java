package com.example.demo.servlet;

import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.GameDao;
import com.example.demo.model.Game;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/games/details")
public class DetailsGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long idGame = Long.parseLong(idStr);
        GameDao dao = DaoFactory.getGameDao();
        Optional<Game> gameOptional = dao.get(idGame);
        if (gameOptional.isPresent()) {
            // Setting data in view
            req.setAttribute("game", gameOptional.get());
        } else {
            System.err.println("Game not found");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/details-game.jsp");
        rd.forward(req, resp);
    }
}
