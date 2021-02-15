package MicronautApp.UsersStore;

import javax.inject.Singleton;

public class UsersAttributes {
    private int age;
    private String phoneNo;
    private String occupation;

    public UsersAttributes(int age, String phoneNo, String occupation) {
        this.age = age;
        this.phoneNo = phoneNo;
        this.occupation = occupation;
    }
}
