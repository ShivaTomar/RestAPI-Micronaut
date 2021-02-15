package MicronautApp.Auth;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import java.util.Collections;

public class auth implements AuthenticationProvider {

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        String userName = authenticationRequest.getIdentity().toString();
        String password = authenticationRequest.getSecret().toString();

        if (password.equals("smith123")) {
            UserDetails details = new UserDetails(userName, Collections.singletonList("ADMIN"));
            return Flowable.just(details);
        } else {
            return Flowable.just(new AuthenticationFailed("Authentication FAILED"));
        }
    }
}