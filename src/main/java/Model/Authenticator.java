package Model;

import java.util.ArrayList;

/**
 * Created by Jonathan on 30-03-2017.
 */
public class Authenticator {
    private String response;

    public Authenticator(){
        response = "";
    }

    public String authenticate (String username, String password){
        Lists l = new Lists();
        ArrayList<User> list = l.getList();
        for(User u: list){
            if (u.getUsername().equals(username) && u.getPassword().equals(password)){
                if (u.getRole() == 1){
                    return "succesAdmin";
                } else if (u.getRole() == 2){
                    return "succesUser";
                }
            }
        }
        return "noUser";
    }
}
