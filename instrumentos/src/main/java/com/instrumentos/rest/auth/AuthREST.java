/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.rest.auth;

import com.instrumentos.jpa.entities.Usuarios;
import com.instrumentos.jpa.sessions.UsuariosFacade;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.math.BigDecimal;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author SennovaAgroPC03
 */
@Path("auth")
public class AuthREST {
    @EJB
    private UsuariosFacade usuariosEJB;
    
    @Path("login")
    @POST
     public Response login(Usuarios usuario) {
         final Usuarios userFound;
         userFound = usuariosEJB.findByEmail(usuario.getEmail());
         if (userFound != null && userFound.getPassword().equals(usuariosEJB.cifrarPassword(usuario.getPassword()))) {
             String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "instrumentos")
                     .setSubject(userFound.getId().toString())
                     .claim("user", userFound.getNombre())
                     .claim("roles", Arrays.toString(userFound.getRolesList().toArray()))
                     .compact();
             JsonObject json = Json.createObjectBuilder().add("token", jwt).build();
             return Response.status(Response.Status.OK).entity(json).build();
         } else {
             return Response.status(Response.Status.UNAUTHORIZED).build();
         }
     }
}
