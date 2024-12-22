/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.GroupMaster;
import entity.UserDetails;
import entity.UserMaster;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Henil
 */
@Stateless
public class LoginSessionBean implements LoginSessionBeanLocal {

    @PersistenceContext(unitName = "my_per_unit")
    private EntityManager em;

    @Override
    public UserMaster authenticate(String email, String password) {
        UserMaster userMaster = new UserMaster();
//        System.out.print(" ejb email" +email + " password" +password);
        try {
            System.out.println("ejb.LoginSessionBean.authenticate() :: email : " + email + " password : " + password + " hash password : " + userMaster.hashPassword(password));
            return em.createQuery("SELECT u FROM UserMaster u WHERE u.companyEmail = :email AND u.password = :password", UserMaster.class)
                    .setParameter("email", email)
                    .setParameter("password", userMaster.hashPassword(userMaster.hashPassword(password)))
                    .getSingleResult();

        } catch (NoResultException e) {
            return null; // Return null if no user found
        }
    }

    // Find UserDetails by userId
    @Override
    public UserDetails findUserDetailsByUserId(int userId) {
        try {
            return em.createQuery("SELECT ud FROM UserDetails ud WHERE ud.userId = :userId", UserDetails.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Return null if no user details found
        }
    }

    // Find GroupMaster by groupId
    @Override
    public GroupMaster findGroupById(int groupId) {
        try {
            return em.createQuery("SELECT g FROM GroupMaster g WHERE g.groupId = :groupId", GroupMaster.class)
                    .setParameter("groupId", groupId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Return null if no group found
        }
    }

}
