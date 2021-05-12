/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.resource;

import br.edu.ifes.ci.cultup.model.domain.Evento;
import br.edu.ifes.ci.cultup.service.EventoService;
import java.util.List;
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
@Path("evento")
public class EventoResource {

    EventoService eventoService = new EventoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getEventosPessoa/{pesscodigo}")
    public List<Evento> findbyPessoa(@PathParam("pesscodigo") String pesscodigo) {
        List<Evento> list = eventoService.FindbyPessoa(pesscodigo);
        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get")
    public List<Evento> search() {
        return eventoService.search();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("update")
    public boolean Alterar(Evento evento) {
        return eventoService.merge(evento);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("insert")
    public boolean Inserir(Evento evento) {
        return eventoService.persist(evento);
    }

}
