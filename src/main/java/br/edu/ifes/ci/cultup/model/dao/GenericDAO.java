/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.dao;

import br.edu.ifes.ci.cultup.model.database.EntityManagerProvider;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author RyanO
 */
public class GenericDAO<T> {

    protected Class clazz;
    private Session session;
    private Transaction ts;

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    private EntityManager manager;

    public EntityManager getManager() {
        if (manager == null || !manager.isOpen()) {
            this.manager = EntityManagerProvider.getInstance().getFactory().createEntityManager();
        }
        return this.manager;
    }

    public void persist(T t) {
        getManager().getTransaction().begin();
        getManager().persist(t);
        getManager().getTransaction().commit();
    }

    public void merge(T t) {
        getManager().getTransaction().begin();
        getManager().merge(t);
        getManager().getTransaction().commit();
    }

    public void remove(T t) {
        getManager().getTransaction().begin();
        getManager().remove(t);
        getManager().getTransaction().commit();
    }

    public List<T> search() {
        session = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        List<T> list = dc.getExecutableCriteria(session).list();
        return list;
    }

    public T FindbyId(Integer id) {
        session = EntityManagerProvider.getInstance().getSession();
        return (T) session.get(clazz, id);
    }

}
