package com.example.demo.dao;

public final class DaoFactory {

    public static GameDao getGameDao() {
//        return new GameJpaDao();
        return new GameJpaDao();
    }

}
