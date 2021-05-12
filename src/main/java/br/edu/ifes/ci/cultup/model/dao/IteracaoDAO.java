/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.dao;

import br.edu.ifes.ci.cultup.model.database.EntityManagerProvider;
import br.edu.ifes.ci.cultup.model.domain.Evento;
import br.edu.ifes.ci.cultup.model.domain.Iteracao;
import br.edu.ifes.ci.cultup.model.domain.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author RyanO
 */
public class IteracaoDAO {

    private EntityManager manager;

    public EntityManager getManager() {
        if (manager == null || !manager.isOpen()) {
            this.manager = EntityManagerProvider.getInstance().getFactory().createEntityManager();
        }
        return this.manager;
    }

    public void persist(Iteracao iteracao) {
        getManager().getTransaction().begin();
        getManager().persist(iteracao);
        getManager().getTransaction().commit();
    }

    public void merge(Iteracao iteracao) {
        getManager().getTransaction().begin();
        getManager().merge(iteracao);
        getManager().getTransaction().commit();
    }

    public void remove(Iteracao iteracao) {
        getManager().getTransaction().begin();
        getManager().remove(iteracao);
        getManager().getTransaction().commit();
    }

    public List<Iteracao> search() {
        Session s = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Iteracao.class);
        return dc.getExecutableCriteria(s).list();
    }

    public Iteracao findIteracao(Pessoa pesscodigo, Evento evecodigo) {
        Session s = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Iteracao.class, "ite");
        dc.add(Restrictions.eq("ite.pesscodigo", pesscodigo));
        dc.add(Restrictions.eq("ite.evecodigo", evecodigo));
        return (Iteracao) dc.getExecutableCriteria(s).uniqueResult();
    }

//  public Iteracao findIteracao(Pessoa pesscodigo, Evento evecodigo) {
//        Session s = EntityManagerProvider.getInstance().getSession();
//            Query query = s.createQuery("FROM Iteracao WHERE pesscodigo = :pesscodigo");
//        query.setParameter("pesscodigo", pesscodigo);
//        //query.setParameter("evecodigo", evecodigo);
//        List list = query.getResultList();
//        return (Iteracao) list.get(0);
//    }
}
