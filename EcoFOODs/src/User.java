/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author A S U S
 */
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String nama;
    private String email;
    private String password;
    private String alamat;
    private String nomorTelp;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public static User signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan email baru: ");
        String email = scanner.next();
        System.out.print("Masukkan password baru: ");
        String password = scanner.next();
        return new User(email, password);
    }

    // Method untuk sign in
    public static User signIn(ArrayList<User> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan email: ");
        String email = scanner.next();
        System.out.print("Masukkan password: ");
        String password = scanner.next();

        for (User user : users) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
