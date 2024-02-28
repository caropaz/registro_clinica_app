package com.registro_clinica.registro_clinica_app.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGrantedAuthorityJsonCreator {

    // Se evita error con la lista de roles, ya que buscaria authority en vez de role
    @JsonCreator
    public SimpleGrantedAuthorityJsonCreator(@JsonProperty("authority")String role){

    }

}
