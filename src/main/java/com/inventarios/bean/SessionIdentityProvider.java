package com.inventarios.bean;
/*
import io.quarkus.security.credential.Credential;
import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.IdentityProvider;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.security.Permission;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped*/
public class SessionIdentityProvider{/*} implements IdentityProvider<SessionAuthenticationRequest> {
    @Inject
    io.vertx.mutiny.mysqlclient.MySQLPool client;

    @Override
    public Class<SessionAuthenticationRequest> getRequestType() {
        return SessionAuthenticationRequest.class;
    }

    @Override
    public Uni<SecurityIdentity> authenticate(SessionAuthenticationRequest sessionAuthenticationRequest, AuthenticationRequestContext authenticationRequestContext) {
        String username = sessionAuthenticationRequest.getUsername();

        Uni<Row> userUni = client
                .preparedQuery("SELECT username, nickname, email, password FROM user WHERE username = ?")
                .execute(Tuple.of(username))
                .onFailure()
                .transform(ForbiddenException::new)
                .onItem()
                .ifNotNull()
                .transformToUni(rows -> rows.toMulti().collect().asList().onItem().transform(records -> records.get(0)));

        Uni<List<String>> rolesUni = client
                .preparedQuery("SELECT role FROM user_role WHERE user = ?")
                .execute(Tuple.of(username))
                .onFailure()
                .transform(ForbiddenException::new)
                .onItem()
                .ifNotNull()
                .transformToUni(rows -> rows.toMulti().onItem().transform(role -> role.getString("role")).collect().asList());
* /
        return Uni.combine().all().unis(userUni, rolesUni).asTuple().onItem().transform(tuple -> {
            Row user = tuple.getItem1();
            String name = user.getString("username");

            List<String> roles = tuple.getItem2();

            return new SecurityIdentity() {
                @Override
                public Principal getPrincipal() {
                    return new Principal() {
                        @Override
                        public String getName() {
                            return name;
                        }
                    };
                }

                @Override
                public boolean isAnonymous() {
                    return false;
                }

                @Override
                public Set<String> getRoles() {
                    return roles.stream().collect(Collectors.toSet());
                }

                @Override
                public boolean hasRole(String s) {
                    return roles.contains(s);
                }

                @Override
                public <T extends Credential> T getCredential(Class<T> aClass) {
                    return null;
                }

                @Override
                public Set<Credential> getCredentials() {
                    return null;
                }

                @Override
                public <T> T getAttribute(String s) {
                    return null;
                }

                @Override
                public Map<String, Object> getAttributes() {
                    return null;
                }

                @Override
                public Uni<Boolean> checkPermission(Permission permission) {
                    return null;
                }
            };
        });
    }*/
}