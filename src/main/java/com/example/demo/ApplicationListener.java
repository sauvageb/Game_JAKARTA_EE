package com.example.demo;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

//@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("APP INITLIAZED");

        // Ouvrir l'EMF

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("APP DESTROYED");

        // Fermer l'EMF

    }
}
