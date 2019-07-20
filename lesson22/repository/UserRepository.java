package lesson22.repository;

public class UserRepository {

    private static User[] users = new User[10];


    public static User[] getUsers() {
        return users;
    }

    private static User findById(long id) {

        for (User usr : users) {
            if (usr != null) {
                if (usr.getId() == id)
                    return usr;

            }
        }
        return null;

    }

    public static User save(User user) {

        if (findById(user.getId()) == null) {
            for (int i = 0; i < getUsers().length; i++) {
                if (getUsers()[i] == null) {
                    getUsers()[i] = user;
                    return getUsers()[i];
                }
            }
        }
        return null;
    }

    public static User update(User user) {

        if (findById(user.getId()) == null) {
            return null;
        } else {
            for (int i = 0; i < getUsers().length; i++) {
                if (getUsers()[i] != null) {
                    getUsers()[i] = user;
                    return getUsers()[i];
                }
            }
        }
        return null;
    }

    public static void delete(long id) {

        User user = findById(id);

        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i] == user) {
                getUsers()[i] = null;
            }
        }
    }
}
