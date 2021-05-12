/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author RyanOliveira
 */
@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.edu.ifes.ci.cultup.resource.CidadeResource.class);
        resources.add(br.edu.ifes.ci.cultup.resource.EnderecoResource.class);
        resources.add(br.edu.ifes.ci.cultup.resource.EventoResource.class);
        resources.add(br.edu.ifes.ci.cultup.resource.IteracaoResource.class);
        resources.add(br.edu.ifes.ci.cultup.resource.PessoaResource.class);
        resources.add(br.edu.ifes.ci.cultup.resource.UfResource.class);
    }
    
}
