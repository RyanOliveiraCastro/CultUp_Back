/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.service;

import br.edu.ifes.ci.cultup.model.dao.EventoDAO;
import br.edu.ifes.ci.cultup.model.dao.IteracaoDAO;
import br.edu.ifes.ci.cultup.model.dao.PessoaDAO;
import br.edu.ifes.ci.cultup.model.domain.Evento;
import br.edu.ifes.ci.cultup.model.domain.Iteracao;
import br.edu.ifes.ci.cultup.model.domain.Pessoa;
import java.util.List;

/**
 *
 * @author rroliveira
 */
public class IteracaoService {

    IteracaoDAO iteracaoDAO = new IteracaoDAO();
    PessoaDAO pessoaDAO = new PessoaDAO();
    EventoDAO eventoDAO = new EventoDAO();

    public boolean merge(Iteracao iteracao) {
        iteracaoDAO.merge(iteracao);
        return true;
    }

    public List<Iteracao> search() {
        return iteracaoDAO.search();
    }

    public Iteracao findIteracao(int pesscodigo, int evecodigo) {
//        Pessoa pessoa = pessoaDAO.FindbyId(pesscodigo);
//        Evento evento = eventoDAO.FindbyId(evecodigo);
        Pessoa pessoa = new Pessoa(pesscodigo);
        Evento evento = new Evento(evecodigo);
        return iteracaoDAO.findIteracao(pessoa, evento);
    }

}
