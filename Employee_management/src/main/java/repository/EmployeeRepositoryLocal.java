/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package repository;

import entity.UserMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Henil
 */
@Local
public interface EmployeeRepositoryLocal {

    Collection<UserMaster> getAllEmployee();
}
