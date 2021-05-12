/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.resource;

import br.edu.ifes.ci.cultup.model.domain.Endereco;
import br.edu.ifes.ci.cultup.service.EnderecoService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author RyanOliveira
 */
@Path("endereco")
public class EnderecoResource {

    EnderecoService enderecoService = new EnderecoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCodigo/{endcodigo}")
    public Endereco buscarCodigo(@PathParam("endcodigo") int endcodigo) {
        return enderecoService.buscarCodigo(endcodigo);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("update")
    public Endereco Alterar(Endereco endereco) {
        enderecoService.merge(endereco);
        return endereco;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insert")
    public Endereco Inserir(Endereco endereco) {
        enderecoService.persist(endereco);
        return endereco;
    }

}
