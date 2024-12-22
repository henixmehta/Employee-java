/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ABC
 */
public class Demo {
    public static void main(String[] args) {
        UserMaster user = new UserMaster();
        
        String pwd = user.hashPassword("henil");
        System.out.println("pwd : "+pwd);
        System.out.println("pwd : "+user.hashPassword(pwd));
    }
}
