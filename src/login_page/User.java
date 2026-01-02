/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_page;

import dashboard.roles.UserRoles;

/**
 *
 * @author sirpa
 */
public class User {
    public String name;
    public String password;
    public UserRoles role;
    
    public User()
    {
        
    }
    
    public User(String name, String password, UserRoles role)
    {
        this.name = name;
        this.password = password;
        this.role = role;
    }
    
}
