/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.dao;

import br.edu.ifes.ci.cultup.model.domain.Pessoa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import br.edu.ifes.ci.cultup.model.database.EntityManagerProvider;
import javax.persistence.EntityManager;

/**
 *
 * @author RyanO
 */
public class PessoaDAO {

    private EntityManager manager;

    public EntityManager getManager() {
        if (manager == null || !manager.isOpen()) {
            this.manager = EntityManagerProvider.getInstance().getFactory().createEntityManager();
        }
        return this.manager;
    }

    public void persist(Pessoa pessoa) {
        getManager().getTransaction().begin();
        getManager().persist(pessoa);
        getManager().getTransaction().commit();
    }

    public void merge(Pessoa pessoa) {
        getManager().getTransaction().begin();
        getManager().merge(pessoa);
        getManager().getTransaction().commit();
    }

    public void remove(Pessoa pessoa) {
        getManager().getTransaction().begin();
        getManager().remove(pessoa);
        getManager().getTransaction().commit();
    }

    public List<Pessoa> search() {
        Session s = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Pessoa.class);
        return dc.getExecutableCriteria(s).list();
    }

    public Pessoa findEmail(String email) {
        Session s = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Pessoa.class, "pessoa");
        dc.add(Restrictions.eq("pessoa.pessemail", email));
        return (Pessoa) dc.getExecutableCriteria(s).uniqueResult();
    }

    public Pessoa FindbyId(Integer id) {
        Session s = EntityManagerProvider.getInstance().getSession();
        return (Pessoa) s.get(Pessoa.class, id);
    }
}
