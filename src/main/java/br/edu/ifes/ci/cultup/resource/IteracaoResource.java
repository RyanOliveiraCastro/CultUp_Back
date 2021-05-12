/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.resource;

import br.edu.ifes.ci.cultup.model.domain.Iteracao;
import br.edu.ifes.ci.cultup.service.IteracaoService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rroliveira
 */
@Path("iteracao")
public class IteracaoResource {

    IteracaoService iteracaoService = new IteracaoService();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("update")
    public boolean Alterar(Iteracao iteracao) {
        return iteracaoService.merge(iteracao);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getIteracao/{pesscodigo}/{evecodigo}")
    public Iteracao findIteracao(@PathParam("pesscodigo") int pesscodigo,
            @PathParam("evecodigo") int evecodigo) {
        return iteracaoService.findIteracao(pesscodigo, evecodigo);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get")
    public List<Iteracao> search() {
        return iteracaoService.search();
    }

}
