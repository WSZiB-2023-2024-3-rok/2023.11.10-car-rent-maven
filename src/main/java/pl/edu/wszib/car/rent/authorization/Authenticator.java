package pl.edu.wszib.car.rent.authorization;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.car.rent.db.UserRepository;
import pl.edu.wszib.car.rent.model.User;

public class Authenticator {
    private final UserRepository userRepository = new UserRepository();

    private final String SEED = "oGvZxgE'i0E+%qnVm7$#AZGL%x3Bua";

    public boolean authenticate(User user) {
        User userFromDB = userRepository.getByLogin(user.getLogin());
        return userFromDB != null &&
                userFromDB.getPassword().equals(DigestUtils.md5Hex(user.getPassword()+SEED));
    }
}
