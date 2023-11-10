package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.User;

public class UserRepository {
    private final User[] users = new User[2];

    public UserRepository() {
        this.users[0] = new User("admin", "362706cff716326a8a8317c9c5bd47f9");
        this.users[1] = new User("janusz", "5550b60e1d08b7c2e88d146c0721de00");
    }

    public User getByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }
}
