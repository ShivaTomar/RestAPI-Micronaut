package MicronautApp.Pet;

import io.micronaut.core.annotation.Introspected;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Introspected
public class Pet {
    @Nullable
    private int _id;

    @NotBlank
    @Size(min = 2, max = 10, message = "Name cannot be short than 2 char & greater than 10 char")
    private String name;

    @NotBlank
    private String breed;

    @NotBlank
    private String category;

    @NotBlank
    private String favouriteItem;

    public Pet(int _id, String name, String breed, String category, String favouriteItem) {
        this._id = _id;
        this.name = name;
        this.breed = breed;
        this.category = category;
        this.favouriteItem = favouriteItem;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFavouriteItem() {
        return favouriteItem;
    }

    public void setFavouriteItem(String favouriteItem) {
        this.favouriteItem = favouriteItem;
    }
}