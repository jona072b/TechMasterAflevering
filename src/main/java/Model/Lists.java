package Model;

import Persistence.FileRead;

import java.util.ArrayList;

/**
 * Created by Jonathan on 30-03-2017.
 */
public class Lists {
    private ArrayList<User> list;

    public Lists (){
        list = null;
    }
    public ArrayList<User> getList(){
        FileRead fr = new FileRead();
        return fr.getUsers();
    }
}
