/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.service;

import br.edu.ifes.ci.cultup.model.dao.PessoaDAO;
import br.edu.ifes.ci.cultup.model.domain.Pessoa;

/**
 *
 * @author RyanOliveira
 */
public class PessoaService {

    PessoaDAO pessoaDAO = new PessoaDAO();

    public Pessoa buscarCodigo(int pessCodigo) {
        return pessoaDAO.FindbyId(pessCodigo);
    }

    public Pessoa buscarEmail(String pessEmail) {
        return pessoaDAO.findEmail(pessEmail);
    }

    public boolean merge(Pessoa pessoa) {
        pessoaDAO.merge(pessoa);
        return true;
    }

    public boolean persist(Pessoa pessoa) {
        pessoaDAO.persist(pessoa);
        return true;
    }

}
