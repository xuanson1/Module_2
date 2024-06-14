package impl;

import entity.User;

public interface Manager {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(int id ,User user);
    void showList();
}
