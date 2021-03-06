package net.olemartin.service.user;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import net.olemartin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ChessAuthenticator implements Authenticator<BasicCredentials, User> {

    private final UserService userService;

    @Autowired
    public ChessAuthenticator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        return userService.getUser(credentials.getUsername(), credentials.getPassword());
    }
}