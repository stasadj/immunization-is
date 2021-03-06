package com.immunization.common.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "email",
    "username",
    "password",
    "firstName",
    "lastName",
    "role", "documents"
})
@XmlRootElement(name = "user")
public class User implements UserDetails {

    public enum ERole {
        GRADANIN, ZDRAVSTVENI_RADNIK, SLUZBENIK 
    }

    private String username, email, password;
    
    @XmlElement(name = "first_name")
    private String firstName;

    @XmlElement(name = "last_name")
    private String lastName;
    
    private ERole role;

    private GradjaninDocuments documents;

    public GradjaninDocuments getDocuments() {
        if (documents == null)
            documents = new GradjaninDocuments();
        return documents;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<Authority> authorities = new ArrayList<>();
        authorities.add(new Authority("ROLE_USER"));
        if (role == ERole.GRADANIN) {
            authorities.add(new Authority("ROLE_GRADANIN"));
        }
        if (role == ERole.ZDRAVSTVENI_RADNIK) {
            authorities.add(new Authority("ROLE_ZDRAVSTVENI_RADNIK"));
        }
        if (role == ERole.SLUZBENIK) {
            authorities.add(new Authority("ROLE_SLUZBENIK"));
        }

        return authorities;
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
