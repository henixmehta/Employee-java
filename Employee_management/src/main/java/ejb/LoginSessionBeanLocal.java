/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.GroupMaster;
import entity.UserDetails;
import entity.UserMaster;
import javax.ejb.Local;

/**
 *
 * @author Henil
 */
@Local
public interface LoginSessionBeanLocal {

    // Method to authenticate the user based on email and password
    UserMaster authenticate(String email, String password);

    // Method to find user details based on userId
    UserDetails findUserDetailsByUserId(int userId);

    // Method to find the group by groupId
    GroupMaster findGroupById(int groupId);
}
