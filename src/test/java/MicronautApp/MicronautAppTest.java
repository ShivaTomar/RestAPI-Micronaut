package MicronautApp;

import MicronautApp.Pet.Pet;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import javax.inject.Inject;
import java.net.MalformedURLException;

@MicronautTest
class MicronautAppTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/") RxHttpClient client;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    public void testAdd() throws MalformedURLException {
        Pet pet = new Pet(1, "Kim","Husky","Dog","Eggs");
        pet = client.toBlocking()
                .retrieve(HttpRequest.POST("/pets", pet).basicAuth("smith", "smith123"), Pet.class);
        Assertions.assertEquals(pet.get_id(), pet.get_id());
    }
}