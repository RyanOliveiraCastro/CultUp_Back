/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.resource;

import br.edu.ifes.ci.cultup.model.domain.Uf;
import br.edu.ifes.ci.cultup.service.UfService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author RyanOliveira
 */
@Path("uf")
public class UfResource {

    UfService ufService = new UfService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get")
    public List<Uf> search() {
        return ufService.search();
    }

}
