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
import java.util.Optional;

@WebServlet(urlPatterns = "/games/delete")
public class DeleteGameServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/delete-game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idGame");

        try {
            Long id = Long.parseLong(idStr);
            GameDao dao = DaoFactory.getGameDao();
            Optional<Game> game = dao.get(id);

            if (game.isPresent()) {
                dao.delete(game.get());
                resp.sendRedirect(req.getContextPath() + "/games");
            } else {
                //TODO : game not found
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

    }
}
