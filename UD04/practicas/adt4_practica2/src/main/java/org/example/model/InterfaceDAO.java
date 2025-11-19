package org.example.model;

import java.util.List;

public interface InterfaceDAO {

    User login(String username, String password);
    List<User> getAll();

}
