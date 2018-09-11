/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instrumentos.rest.services;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author SennovaAgroPC03
 */

@ApplicationPath("api")
public class AppConfig extends ResourceConfig{
    public AppConfig() {
        packages("com.instrumentos.rest.services");
    }
}
