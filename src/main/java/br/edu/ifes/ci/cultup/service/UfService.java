/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.service;

import br.edu.ifes.ci.cultup.model.dao.UfDAO;
import br.edu.ifes.ci.cultup.model.domain.Uf;
import java.util.List;

/**
 *
 * @author RyanOliveira
 */
public class UfService {

    UfDAO ufDAO = new UfDAO();

    public List<Uf> search() {
        return ufDAO.search();
    }

}
