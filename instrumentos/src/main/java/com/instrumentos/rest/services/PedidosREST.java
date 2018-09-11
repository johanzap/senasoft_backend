/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.rest.services;

import com.instrumentos.jpa.entities.Pedidos;
import com.instrumentos.jpa.entities.Usuarios;
import com.instrumentos.jpa.sessions.PedidosFacade;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SennovaAgroPC03
 */
@Path("pedidos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidosREST {
    @EJB
    private PedidosFacade pedidosEJB;
    
    @POST
    public Pedidos create(Pedidos pedido) {
        pedidosEJB.create(pedido);
        return pedido;
    }
    
    @GET
    public List<Pedidos> findAll() {
        return pedidosEJB.findAll();
    }
    
    @PUT
    public Pedidos edit(Pedidos pedido) {
        pedidosEJB.edit(pedido);
        return pedido;
    }
    
    
    @Path("/{id}")
    @GET
    public void delete(@PathParam("id") Integer id) {
        final Pedidos pedidoFound;
        pedidoFound = pedidosEJB.find(id);
        pedidosEJB.remove(pedidoFound);
    }
    
    @Path("/{id}")
    @DELETE
    public Pedidos find(@PathParam("id") Integer id) {
        return pedidosEJB.find(id);
    }
    
    @GET
    @Path("consultarPedidos")
    public List<Pedidos> consultarPedidos(@QueryParam("idUsuario") Integer idUsuario) {
        return pedidosEJB.consultarPedidos(idUsuario);
    }
}
