package com.chronos.mvpapi.security;

import com.chronos.mvpapi.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UsuarioSistema extends User {

    private static final long serialVersionUID = 1L;

    private Person usuario;

    public UsuarioSistema(Person usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getEmail(), usuario.getPassword(), authorities);
        this.usuario = usuario;
    }

    public Person getUsuario() {
        return usuario;
    }
}
