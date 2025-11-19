package org.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements InterfaceDAO {

    private Connection accesoBD = null;

    public UserDAO(){
        accesoBD = GestionBD.getConnection();
    }

    @Override
    public User login(String username, String password) {
        User user = null;

        try {
            String sqlLogin = "SELECT * FROM usuario WHERE nombre = ? AND password = ?";
            PreparedStatement psLogin =  accesoBD.prepareStatement(sqlLogin);
            psLogin.setString(1, username);
            psLogin.setString(2, password);

            ResultSet resultado =  psLogin.executeQuery();

            if (resultado.next()) {
                user = new User();
                user.setId(resultado.getInt(1));
                user.setUsername(resultado.getString(2));
                user.setPassword(resultado.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Error UsuarioDAO - login: " + e.getMessage());
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        User user;

        try {
            String sqlGetAll = "SELECT * FROM usuario";
            PreparedStatement psGetAll = accesoBD.prepareStatement(sqlGetAll);
            ResultSet resultado = psGetAll.executeQuery();

            while (resultado.next()) {
                user = new User();
                user.setId(resultado.getInt(1));
                user.setUsername(resultado.getString(2));
                user.setPassword(resultado.getString(3));
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error UsuarioDAO - getAll: " + e.getMessage());
        }

        return users;
    }
}
