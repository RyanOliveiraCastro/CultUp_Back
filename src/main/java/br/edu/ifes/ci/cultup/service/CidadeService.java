/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.service;

import br.edu.ifes.ci.cultup.model.dao.CidadeDAO;
import br.edu.ifes.ci.cultup.model.domain.Cidade;
import br.edu.ifes.ci.cultup.model.domain.Uf;
import java.util.List;

/**
 *
 * @author RyanOliveira
 */
public class CidadeService {

    CidadeDAO cidadeDAO = new CidadeDAO();

    public List<Cidade> FindbyUf(Uf uf) {
        return cidadeDAO.findbyUf(uf);
    }

}
