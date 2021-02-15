package MicronautApp.Pet;

import io.reactivex.Single;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class PetServiceImpl implements PetService {

    private Map<Integer, Pet> pets;

    public PetServiceImpl() {
        pets = new HashMap<>();
    }

    @Override
    public Single<List<Pet>> allPets() {
        return Single.just(new ArrayList<>(pets.values()));
    }

    @Override
    public Single<Optional<Pet>> details(int id) {
        return Single.defer(() -> Single.just(Optional.ofNullable(pets.get(id))));
    }

    @Override
    public Single<Integer> addPet(Pet pet) {
        int petId = pets.size() + 1;
        pet.set_id(petId);
        if (pet.getBreed() == "") pet.setBreed("Unknown");

        pets.put(petId, pet);
        return Single.just(petId);
    }

    @Override
    public void updatePet(int id, Pet pet) {
        pets.put(id, pet);
    }

    @Override
    public void deletePet(int id) {
        pets.remove(id);
    }
}
