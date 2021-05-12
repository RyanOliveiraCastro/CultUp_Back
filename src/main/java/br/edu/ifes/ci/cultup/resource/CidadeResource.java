/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.resource;

import br.edu.ifes.ci.cultup.model.domain.Cidade;
import br.edu.ifes.ci.cultup.model.domain.Uf;
import br.edu.ifes.ci.cultup.service.CidadeService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author RyanOliveira
 */
@Path("cidade")
public class CidadeResource {

    CidadeService cidadeService = new CidadeService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUf/{uf}")
    public List<Cidade> findbyUf(@PathParam("uf") Integer ufcodigo) {
        Uf uf = new Uf();
        uf.setUfcodigo(ufcodigo);
        List<Cidade> list = cidadeService.FindbyUf(uf);
        return list;
    }
}
