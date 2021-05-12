/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.service;

import br.edu.ifes.ci.cultup.model.dao.EnderecoDAO;
import br.edu.ifes.ci.cultup.model.domain.Endereco;

/**
 *
 * @author RyanOliveira
 */
public class EnderecoService {

    EnderecoDAO enderecoDAO = new EnderecoDAO();

    public Endereco buscarCodigo(int endCodigo) {
        return enderecoDAO.FindbyId(endCodigo);
    }

    public boolean merge(Endereco endereco) {
        enderecoDAO.merge(endereco);
        return true;
    }

    public boolean persist(Endereco endereco) {
        enderecoDAO.persist(endereco);
        return true;
    }
}
