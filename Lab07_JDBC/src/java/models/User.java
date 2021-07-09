package models;

import java.io.Serializable;

/**
 *
 * @author 840288
 */
public class User implements Serializable {
    private String email;
    private boolean active;
    private String firstname;
    private String lastname;
    private String password;
    private int role;
    
    public User(){
    }
    
    public User(String email, boolean active, String firstname, String lastname, String password,int role) {
        email = this.email;
        active = this.active;
        firstname = this.firstname;
        lastname = this.lastname;
        password = this.password;
        role = this.role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }  

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
