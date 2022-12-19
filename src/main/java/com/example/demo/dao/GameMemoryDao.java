package com.example.demo.dao;

import com.example.demo.model.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameMemoryDao implements GameDao {

    private static Long idSequence = 1L;

    private static List<Game> games = new ArrayList<Game>() {{
        add(new Game(idSequence++, "Counter Strike GO", "Jeu de tir à la première personne"));
        add(new Game(idSequence++, "Civilization", "eu vidéo de stratégie au tour par tour de type 4X"));
    }};


    @Override
    public Optional<Game> get(Long id) {
        return games.stream().filter(g -> g.getId().equals(id)).findFirst();
    }

    @Override
    public List<Game> getAll() {
        return games;
    }

    @Override
    public void save(Game game) {
        game.setId(idSequence++);
        this.games.add(game);
    }

    @Override
    public void update(Game gameParam) {
        games.stream()
                .forEach(game -> {
                    if (game.getId().equals(gameParam.getId())) {
                        game.setName(gameParam.getName());
                        game.setDescription(gameParam.getDescription());
                    }
                });
    }

    @Override
    public void delete(Game gameToDelete) {
        games = games.stream()
                .filter(game -> !game.getId().equals(gameToDelete.getId()))
                .collect(Collectors.toList());
    }
}
