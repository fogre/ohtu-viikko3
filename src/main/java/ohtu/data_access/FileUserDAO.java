/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

/**
 *
 * @author ajkotira
 */
public class FileUserDAO implements UserDao {
    
    private Scanner reader = null;
    private final String filename;
    private List<User> users;
    
    public FileUserDAO(String fileAddress){
        this.filename=fileAddress;
    }
    
    public boolean setReader(){
        try {
            reader = new Scanner(new File(filename));
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("FILE NOT FOUND!!!!!!!!!!!");
            return false;
        }
    }

    @Override
    public List<User> listAll() {
        if(setReader()){
            while(reader.hasNextLine()){
                String username = reader.next();
                String password = reader.next();
                User u = new User(username, password);
                users.add(u);
                reader.nextLine();
            }reader.close();
        }return users; //checkstyle testien ehdot aiheuttavat rumaa koodia. kiitos.
    }

    @Override
    public User findByName(String name) {
        if(setReader()){
            while(reader.hasNext()){
                String s = reader.next();
                if(s.equals(name)){
                    User u = new User(s, reader.next());
                    reader.close();
                    return u;
                }reader.next();
            }
        }reader.close(); return null; //fuck checkstyle!!!!! Tehdään sitte rumaa koodia :D
    }

    @Override
    public void add(User user) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(user.getUsername() + " " + user.getPassword() + "\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
