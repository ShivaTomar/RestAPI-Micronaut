package MicronautApp.Pet;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Single;
import javax.inject.Inject;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/pets")
public class PetController {

    @Inject
    public PetServiceImpl petService;

    @Get("/")
    public Single<List<Pet>> allPets() {
        return petService.allPets();
    }

    @Post("/")
    @Secured("ADMIN")
    public Single<Integer> addPet(@Body Pet pet) {
        return petService.addPet(pet);
    }

    @Get("/{id}")
    public Single<Optional<Pet>> getPetDetails(Integer id) {
        return petService.details(id);
    }

    @Put("/{id}")
    public HttpStatus updatePet(@PathVariable Integer id, @Body Pet pet) {
        pet.set_id(id);
        petService.updatePet(id, pet);
        return HttpStatus.OK;
    }

    @Delete("/{id}")
    @Secured("ADMIN")
    public HttpStatus deletePet(@PathVariable Integer id) {
        petService.deletePet(id);
        return HttpStatus.OK;
    }

    @Get("/login")
    public Single<String> login(Principal principal) {
        return Single.just("Welcome to the PetStore-Service you are logged in as: "+principal.getName());
    }
}