package Persistence;

import Model.User;

import java.util.ArrayList;

/**
 * Created by Jonathan on 30-03-2017.
 */
public class FileRead {

    public ArrayList<User> getUsers(){
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("admin", "admin", 1));
        list.add(new User("user", "user",2));
        return list;
    }

}
