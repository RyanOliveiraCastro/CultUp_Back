/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.dao;

import br.edu.ifes.ci.cultup.model.database.EntityManagerProvider;
import br.edu.ifes.ci.cultup.model.domain.Evento;
import br.edu.ifes.ci.cultup.model.domain.Pessoa;
import br.edu.ifes.ci.cultup.model.domain.Relatorio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author RyanO
 */
public class EventoDAO {

    private EntityManager manager;

    public EntityManager getManager() {
        if (manager == null || !manager.isOpen()) {
            this.manager = EntityManagerProvider.getInstance().getFactory().createEntityManager();
        }
        return this.manager;
    }

    public void persist(Evento evento) {
        getManager().getTransaction().begin();
        getManager().persist(evento);
        getManager().getTransaction().commit();
    }

    public void merge(Evento evento) {
        getManager().getTransaction().begin();
        getManager().merge(evento);
        getManager().getTransaction().commit();
    }

    public void remove(Evento evento) {
        getManager().getTransaction().begin();
        getManager().remove(evento);
        getManager().getTransaction().commit();
    }

    public List<Evento> search() {
        Session s = EntityManagerProvider.getInstance().getSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Evento.class);
        return dc.getExecutableCriteria(s).list();
    }

    public List<Evento> findByPessoa(Pessoa pessoa) {
        Session s = EntityManagerProvider.getInstance().getSession();
        Query query = s.createQuery("FROM Evento WHERE pesscodigo = :pesscodigo ");
        query.setParameter("pesscodigo", pessoa);
        List list = query.getResultList();
        return list;
    }

    public Evento FindbyId(Integer id) {
        Session s = EntityManagerProvider.getInstance().getSession();
        return (Evento) s.get(Evento.class, id);
    }

    public Map<Integer, ArrayList> listarQuantidadeEventoPorMes(Integer id) {
        Map<Integer, ArrayList> retorno = new HashMap();
        Session s = EntityManagerProvider.getInstance().getSession();
        Query query = s.createSQLQuery("SELECT COUNT(evecodigo) AS count, "
                + "EXTRACT(year from evedata) AS ano, EXTRACT(month from evedata) AS mes "
                + "FROM evento WHERE pesscodigo = " + id + "GROUP BY ano, mes ORDER BY ano, mes");

        List list = query.getResultList();
        List<Relatorio> listRelatorio = new ArrayList();
        for (Object object : list) {
            Relatorio relatorio = new Relatorio();
            Object[] obUnit = (Object[]) object;
            relatorio.setCount(Integer.parseInt(String.valueOf(obUnit[0])));
            relatorio.setAno((int) Double.parseDouble(String.valueOf(obUnit[1])));
            relatorio.setMes((int) Double.parseDouble(String.valueOf(obUnit[2])));
            listRelatorio.add(relatorio);
        }

        for (Relatorio relatorio : listRelatorio) {
            ArrayList linha = new ArrayList();
            if (!retorno.containsKey(relatorio.getAno())) {
                linha.add(relatorio.getMes());
                linha.add(relatorio.getCount());
                retorno.put(relatorio.getAno(), linha);
            } else {
                ArrayList linhaNova = retorno.get(relatorio.getAno());
                linhaNova.add(relatorio.getMes());
                linhaNova.add(relatorio.getCount());
            }
        }
        return retorno;

        //return listEvento;
    }
}
