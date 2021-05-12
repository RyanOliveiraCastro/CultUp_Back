/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.service;

import br.edu.ifes.ci.cultup.model.dao.EventoDAO;
import br.edu.ifes.ci.cultup.model.domain.Evento;
import br.edu.ifes.ci.cultup.model.domain.Pessoa;
import java.util.List;

/**
 *
 * @author RyanOliveira
 */
public class EventoService {

    EventoDAO eventoDAO = new EventoDAO();

    public List<Evento> FindbyPessoa(String pesscodigo) {
        Pessoa pessoa = new Pessoa(Integer.valueOf(pesscodigo));
        return eventoDAO.findByPessoa(pessoa);
    }

    public List<Evento> search() {
        return eventoDAO.search();
    }

    public boolean merge(Evento evento) {
        eventoDAO.merge(evento);
        return true;
    }

    public boolean persist(Evento evento) {
        eventoDAO.persist(evento);
        return true;
    }

}
