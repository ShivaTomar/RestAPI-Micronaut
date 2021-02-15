package MicronautApp.Auth;

import MicronautApp.UsersStore.UsersAttributes;
import MicronautApp.UsersStore.UsersStore;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class auth implements AuthenticationProvider {

    @Inject
    public UsersStore store;

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        String username = authenticationRequest.getIdentity().toString();
        String password = authenticationRequest.getSecret().toString();

        if (password.equals(store.getUserPassword(username))) {
            UserDetails details = new UserDetails(username, Collections.singletonList(store.getUserRole(username)), store.getUserAttr(username));

            return Flowable.just(details);
        } else {
            return Flowable.just(new AuthenticationFailed("Authentication FAILED"));
        }
    }
}