package mx.edu.utez.easyHost.service;

import mx.edu.utez.easyHost.model.Usuario;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private  String email;
    private  String password;
    private  boolean nonLoked;
    private List<GrantedAuthority> authorities;


    public UserDetails (Usuario usuario){
        email =  usuario.getCorreo();
        password = usuario.getContrasenia();
        authorities = new ArrayList<>();
        authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority(usuario.getRol().getNombre()));
        nonLoked = true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return nonLoked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
