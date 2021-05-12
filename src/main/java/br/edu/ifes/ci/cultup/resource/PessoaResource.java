package br.edu.ifes.ci.cultup.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import br.edu.ifes.ci.cultup.model.domain.Pessoa;
import br.edu.ifes.ci.cultup.service.PessoaService;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author RyanOliveira
 */
@Path("pessoa")
public class PessoaResource {

    public PessoaResource() {
    }

    private PessoaService pessoaService = new PessoaService();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("update")
    public boolean Alterar(Pessoa pessoa) {
        return pessoaService.merge(pessoa);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("insert")
    public boolean Inserir(Pessoa pessoa) {
        return pessoaService.persist(pessoa);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCodigo/{pesscodigo}")
    public Pessoa buscarCodigo(@PathParam("pesscodigo") int pesscodigo) {
        return pessoaService.buscarCodigo(pesscodigo);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getEmail/{pessemail}")
    public Pessoa buscarEmail(@PathParam("pessemail") String pessemail) {
        return pessoaService.buscarEmail(pessemail);
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("Pessoa/getCodigo/{pesscodigo}")
//    public Pessoa getPessCodigo(@PathParam("pesscodigo") int pesscodigo) {
//        PessoaDAO pessoaDAO = new PessoaDAO();
//        Pessoa pessoa = pessoaDAO.FindbyId(pesscodigo);
//        return pessoa;
//    }
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("Pessoa/getEmail/{pessemail}")
//    public Pessoa getPessEmail(@PathParam("pessemail") String pessemail) {
//        PessoaDAO pessoaDAO = new PessoaDAO();
//        Pessoa pessoa = pessoaDAO.findEmail(pessemail);
//        System.out.println(pessoa);
//        return pessoa;
//    }
}
