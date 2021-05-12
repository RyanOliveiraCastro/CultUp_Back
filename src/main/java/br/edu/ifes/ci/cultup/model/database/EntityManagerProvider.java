/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author fernando
 */
public class EntityManagerProvider {

    private static EntityManagerProvider instance;
    private static EntityManagerFactory factory;

    private EntityManagerProvider() {
        factory = Persistence.createEntityManagerFactory("poo1");
    }

    public static EntityManagerProvider getInstance() {
        if (instance == null) {
            try {
                instance = new EntityManagerProvider();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return instance;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public Session getSession() {
        return factory.createEntityManager().unwrap(Session.class);
    }

}
