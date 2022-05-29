package nt.WareHouse.auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static nt.WareHouse.auth.UserPermissions.*;

public enum UserRoles {
    USER(Set.of(READ, READ_BY_PARAM), "GUEST"),
    ADMIN(Set.of(CREATE, UPDATE, READ, READ_BY_ID, READ_BY_PARAM, DELETE), "ADMIN"),
    MODERATOR(Set.of(UPDATE, READ_BY_ID, READ_BY_PARAM, READ), "MODERATOR");

    private final Set<UserPermissions> permissions;
    private final String name;

    UserRoles(Set<UserPermissions> permissions, String name) {
        this.permissions = permissions;
        this.name = name;
    }
    public Set<SimpleGrantedAuthority> getPermissions(){
        Set<SimpleGrantedAuthority> authorities =
                permissions.stream()
                        .map(p -> new SimpleGrantedAuthority(p.getName()))
                        .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name));

        return authorities;
    }
}
