package MicronautApp.Pet;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Single;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/pets")
public class PetController {

    @Inject
    public PetServiceImpl petService;

    @Get("/")
    public Single<List<Pet>> allPets() {
        return petService.allPets();
    }

    @Post("/")
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
    public HttpStatus deletePet(@PathVariable Integer id) {
        petService.deletePet(id);
        return HttpStatus.OK;
    }
}