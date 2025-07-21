package socialsphere.dao;

import socialsphere.model.User;

public interface UserDAO {
    int addUser(User user);
    boolean checkIfUserExists(User user);
    boolean loginUser(User user);
}
