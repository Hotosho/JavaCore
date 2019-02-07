package lesson9.HomeWork;

public class UserRepository {

    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public int countUsers() {
        int i = 0;

        for (User usr : users) {
            if (usr != null)
                i++;
        }
        return i;
    }

    public String[] getUserNames(User[] users) {

        String[] names = new String[countUsers()];

        int i = 0;
        for (User usr : users) {
            if (usr != null) {
                names[i] = usr.getName();
            }
        }
        return names;

    }

    public Long[] getUserIds(User[] users) {

        Long[] id = new Long[countUsers()];

        int i = 0;
        for (User usr : users) {
            if (usr != null) {
                id[i] = usr.getId();
            }
        }
        return id;
    }

    public String getUserNameById(long id) {

        for (User usr : users) {
            if (usr != null) {
                if (usr.getId() == id)
                    return usr.getName();
            }
        }
        return null;
    }

    public User getUserByName(String name) {

        for (User usr : users) {
            if (usr != null) {
                if (usr.getName() == name)
                    return usr;
            }
        }
        return null;
    }

    public User getUserById(long id) {

        for (User usr : users) {
            if (usr != null) {
                if (usr.getId() == id)
                    return usr;

            }
        }
        return null;
    }

    public User getUserBySessionld(String sessionld) {

        for (User usr : users) {
            if (usr != null) {
                if (usr.getSessionId() == sessionld) ;
                return usr;
            }
        }
        return null;
    }

    private User findById(long id) {

        for (User usr : users) {
            if (usr != null) {
                if (usr.getId() == id)
                    return usr;

            }
        }
        return null;

    }

    public User save(User user) {

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

    public User update(User user) {

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

    public void delete(long id) {

        User user = findById(id);

        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i] == user) {
                getUsers()[i] = null;
            }
        }
    }
}
