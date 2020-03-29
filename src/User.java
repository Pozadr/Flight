import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String nick;
    private String password;
    private String emailAdress;

    public User(){
        this.nick = getNickFromUser();
    }

    public String getNick() {
        return nick;
    }

    public ArrayList<String> getRequestFromUser(){  //String["departure", "arrival"]
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> request = new ArrayList<>();
        System.out.println("Type departure: ");
        request.add(keyboard.next());
        System.out.println("Type arrival: ");
        request.add(keyboard.next());

        return request;
    }

    public String getNickFromUser(){
        String nick;
        Scanner keyboard = new Scanner(System.in);

        while(true){
            System.out.print("Type your nick: ");
            nick = keyboard.next();
            if(nick.length() > 1){
                return nick;
            }
            else{
                System.out.println("Nick name is too short. Try again");
            }
        }
    }

    public void displayNick(){
        System.out.println("Your nick is: " + this.nick);
    }

}
