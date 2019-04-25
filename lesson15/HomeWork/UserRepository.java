package lesson15.HomeWork;

public class UserRepository {

    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {

        if (findUserById(user.getId()) == null) {
            for (int i = 0; i < getUsers().length; i++) {
                if (getUsers()[i] == null)
                    getUsers()[i] = user;
                return getUsers()[i];
            }
        }
        return null;
    }


    public User update(User user) {

        if (findUserById(user.getId()) != null) {
            for (int i = 0; i < getUsers().length; i++) {
                if (getUsers()[i].equals(user.getId())) {
                    getUsers()[i] = user;
                    return getUsers()[i];
                }
            }
        }
        return null;
    }

    public void delete(long id) {

        User user = findUserById(id);
        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i] == user)
                user = null;
        }
    }

    public User findUser(User user){
        for (User usr : users){
            if (usr.equals(user))
                return user;
        }
        return null;
    }


    private User findUserById(long id) {

        for (User user : users) {
            if (user != null) {
                if (user.getId() == id)
                    return user;
            }
        }
        return null;
    }
}