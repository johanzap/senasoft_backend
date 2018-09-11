/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author SennovaAgroPC03
 */
@Embeddable
public class ProductosHasPedidosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_productos")
    private int idProductos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedidos")
    private int idPedidos;

    public ProductosHasPedidosPK() {
    }

    public ProductosHasPedidosPK(int idProductos, int idPedidos) {
        this.idProductos = idProductos;
        this.idPedidos = idPedidos;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public int getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProductos;
        hash += (int) idPedidos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosHasPedidosPK)) {
            return false;
        }
        ProductosHasPedidosPK other = (ProductosHasPedidosPK) object;
        if (this.idProductos != other.idProductos) {
            return false;
        }
        if (this.idPedidos != other.idPedidos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.instrumentos.jpa.entities.ProductosHasPedidosPK[ idProductos=" + idProductos + ", idPedidos=" + idPedidos + " ]";
    }
    
}
