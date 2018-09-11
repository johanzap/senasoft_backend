/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.rest.services;

import com.instrumentos.jpa.entities.Pedidos;
import com.instrumentos.jpa.entities.ProductosHasPedidos;
import com.instrumentos.jpa.entities.ProductosHasPedidosPK;
import com.instrumentos.jpa.sessions.PedidosFacade;
import com.instrumentos.jpa.sessions.ProductosHasPedidosFacade;
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
@Path("item-pedidos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemPedidoREST {
    @EJB
    private ProductosHasPedidosFacade productosHasPedidosEJB;
    
    @POST
    public ProductosHasPedidos create(@QueryParam("pedidoId") Integer pedidoId,
                                      @QueryParam("productId") Integer productId,
                                      ProductosHasPedidos php) {
        php.setProductosHasPedidosPK(new ProductosHasPedidosPK(productId, pedidoId));
        productosHasPedidosEJB.create(php);
        return php;
    }
    
    @GET
    public List<ProductosHasPedidos> findAll() {
        return productosHasPedidosEJB.findAll();
    }
    
    @PUT
    public ProductosHasPedidos edit(ProductosHasPedidos php) {
        productosHasPedidosEJB.edit(php);
        return php;
    }
    
    
    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") Integer id) {
        final ProductosHasPedidos phpFound;
        phpFound = productosHasPedidosEJB.find(id);
        productosHasPedidosEJB.remove(phpFound);
    }
    
    @Path("/{id}")
    @GET
    public ProductosHasPedidos find(@PathParam("id") Integer id) {
        return productosHasPedidosEJB.find(id);
    }
}
