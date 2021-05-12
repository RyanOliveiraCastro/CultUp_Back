/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.dao;

import br.edu.ifes.ci.cultup.model.domain.Uf;
import br.edu.ifes.ci.cultup.model.database.EntityManagerProvider;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author RyanO
 */
public class UfDAO {

    private EntityManager manager;

    public EntityManager getManager() {
        if (manager == null || !manager.isOpen()) {
            this.manager = EntityManagerProvider.getInstance().getFactory().createEntityManager();
        }
        return this.manager;
    }

    public List<Uf> search() {
        Session s = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Uf.class);
        return dc.getExecutableCriteria(s).list();
    }

}
