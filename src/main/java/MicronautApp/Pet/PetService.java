package MicronautApp.Pet;

import io.reactivex.Single;
import java.util.List;
import java.util.Optional;

public interface PetService {
    Single<List<Pet>> allPets();
    Single<Optional<Pet>> details(int id);
    Single<Integer> addPet(Pet pet);
    void updatePet(int id, Pet pet);
    void deletePet(int id);
}
