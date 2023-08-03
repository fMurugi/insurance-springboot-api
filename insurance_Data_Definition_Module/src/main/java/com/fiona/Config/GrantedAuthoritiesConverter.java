//package com.fiona.Config;
//
//import com.fasterxml.jackson.databind.JavaType;
//import com.fasterxml.jackson.databind.type.TypeFactory;
//import com.fasterxml.jackson.databind.util.Converter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class GrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
//
//    private static final String REALM_ACCESS_CLAIM = "realm_access";
//    private static final String ROLES_CLAIM = "roles";
//    private static final String ROLE_PREFIX = "ROLE_";
//
//    @Override
//    public Collection<GrantedAuthority> convert(Jwt source) {
//        Map<String, Object> claims = source.getClaims();
//
//        if (claims.containsKey(REALM_ACCESS_CLAIM)) {
//            Map<String, Object> realmAccess = (Map<String, Object>) claims.get(REALM_ACCESS_CLAIM);
//
//            if (realmAccess.containsKey(ROLES_CLAIM)) {
//                List<String> roles = (List<String>) realmAccess.get(ROLES_CLAIM);
//
//                if (Objects.nonNull(roles)) {
//                    return roles.stream()
//                            .map(rn -> new SimpleGrantedAuthority(ROLE_PREFIX + rn))
//                            .collect(Collectors.toList());
//                }
//            }
//        }
//
//        return Collections.emptyList();
//    }
//
//    @Override
//    public JavaType getInputType(TypeFactory typeFactory) {
//        return typeFactory.constructType(Jwt.class);
//    }
//
//    @Override
//    public JavaType getOutputType(TypeFactory typeFactory) {
//        return typeFactory.constructCollectionType(List.class, GrantedAuthority.class);
//    }
//}