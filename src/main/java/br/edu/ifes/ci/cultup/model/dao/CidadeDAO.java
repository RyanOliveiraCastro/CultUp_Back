/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.dao;

import br.edu.ifes.ci.cultup.model.database.EntityManagerProvider;
import br.edu.ifes.ci.cultup.model.domain.Cidade;
import br.edu.ifes.ci.cultup.model.domain.Uf;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author RyanO
 */
public class CidadeDAO {

    private EntityManager manager;

    public EntityManager getManager() {
        if (manager == null || !manager.isOpen()) {
            this.manager = EntityManagerProvider.getInstance().getFactory().createEntityManager();
        }
        return this.manager;
    }

    public List<Cidade> search() {
        Session s = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Cidade.class);
        return dc.getExecutableCriteria(s).list();
    }

    public List<Cidade> findbyUf(Uf uf) {
        Session s = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Cidade.class, "cidade");
        dc.createAlias("cidade.ufcodigo", "uf");
        dc.add(Restrictions.eq("cidade.ufcodigo", uf));
        return dc.getExecutableCriteria(s).list();
    }
}
