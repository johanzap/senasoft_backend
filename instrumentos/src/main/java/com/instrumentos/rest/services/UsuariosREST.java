/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.rest.services;

import com.instrumentos.jpa.entities.Usuarios;
import com.instrumentos.jpa.sessions.UsuariosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SennovaAgroPC03
 */
@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosREST {
    @EJB
    private UsuariosFacade usuariosEJB;
    
    @POST
    public Usuarios create(Usuarios usuario) {
        usuario.setPassword(usuariosEJB.cifrarPassword(usuario.getPassword()));
        usuariosEJB.create(usuario);
        return usuario;
    }
    
    @GET
    public List<Usuarios> findAll() {
        return usuariosEJB.findAll();
    }
    
    @PUT
    public Usuarios edit(Usuarios usuario) {
        usuariosEJB.edit(usuario);
        return usuario;
    }
    
    
    @Path("/{id}")
    @GET
    public void delete(@PathParam("id") Integer id) {
        final Usuarios usuarioFound;
        usuarioFound = usuariosEJB.find(id);
        usuariosEJB.remove(usuarioFound);
    }
    
    @Path("/{id}")
    @DELETE
    public Usuarios find(@PathParam("id") Integer id) {
        return usuariosEJB.find(id);
    }
}
