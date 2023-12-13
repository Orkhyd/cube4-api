package edu.cesi.cube4.auth;

import edu.cesi.cube4.model.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthUser extends Admin implements UserDetails {

    private final Admin admin;

    public AuthUser(Admin admin) {
        this.admin = admin;
    }

    @Override
    public Collection   <? extends GrantedAuthority> getAuthorities() {
        return null;

    }

    @Override
    public String getPassword() {
        return admin.getMotDePasse();
    }

    @Override
    public String getUsername() {
        return admin.getNomUtilisateur();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
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
