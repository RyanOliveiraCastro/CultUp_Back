/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.dao;

import br.edu.ifes.ci.cultup.model.database.EntityManagerProvider;
import br.edu.ifes.ci.cultup.model.domain.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author rroliveira
 */
public class EnderecoDAO {

    private EntityManager manager;

    public EntityManager getManager() {
        if (manager == null || !manager.isOpen()) {
            this.manager = EntityManagerProvider.getInstance().getFactory().createEntityManager();
        }
        return this.manager;
    }

    public void persist(Endereco endereco) {
        getManager().getTransaction().begin();
        getManager().persist(endereco);
        getManager().getTransaction().commit();
    }

    public void merge(Endereco endereco) {
        getManager().getTransaction().begin();
        getManager().merge(endereco);
        getManager().getTransaction().commit();
    }

    public void remove(Endereco endereco) {
        getManager().getTransaction().begin();
        getManager().remove(endereco);
        getManager().getTransaction().commit();
    }

    public List<Endereco> search() {
        Session s = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Endereco.class);
        return dc.getExecutableCriteria(s).list();
    }

    public Endereco FindbyId(Integer id) {
        Object endereco;
        Session s = EntityManagerProvider.getInstance().getSession();
        endereco = s.get(Endereco.class, id);
        s.close();
        return (Endereco) endereco;
    }

}
