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

@WebServlet(urlPatterns = "/games/edit")
public class EditGameServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Getting id query param (in url)
        String idStr = req.getParameter("id");

        Long idGame = Long.parseLong(idStr);
        GameDao dao = DaoFactory.getGameDao();
        Optional<Game> gameOptional = dao.get(idGame);
        if (gameOptional.isPresent()) {
            // Setting data in view
            req.setAttribute("gameEdit", gameOptional.get());
        } else {
            req.setAttribute("gameNotFound", true);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/edit-game.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String name = req.getParameter("gameName");
        String description = req.getParameter("gameDescription");

        GameDao gameDao = DaoFactory.getGameDao();
        try {
            Long idGame = Long.parseLong(idStr);
            Optional<Game> gameOptional = gameDao.get(idGame);

            if (gameOptional.isPresent()) {
                Game gameToEdit = gameOptional.get();
                gameToEdit.setName(name);
                gameToEdit.setDescription(description);
                gameDao.update(gameToEdit);

                resp.sendRedirect(req.getContextPath() + GameListServlet.URL);

            } else {
                System.err.println("Cannot update game with id=" + idStr);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
