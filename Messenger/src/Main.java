import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String message = formMessage();
        System.out.println(message);
    }
    public static String formMessage() throws IOException {



        JsonReader reader = new JsonReader(new FileReader("Companies.json"));
    JsonReader guestsJson = new JsonReader(new FileReader("Guests.json"));
    JsonReader messageJson = new JsonReader(new FileReader("Messages.json"));


        Gson gson = new Gson();
       Type typeOfList = new TypeToken<List<Company>>(){}.getType();
       List<Company> companies = gson.fromJson(reader, typeOfList);
        HashMap<Integer, Company> companyMap = new HashMap<>();
       for(Company c : companies){

           companyMap.put(c.getId(), c);


       }

       Type typeOfGuestList = new TypeToken<List<Guest>>(){}.getType();
       List<Guest> guests = gson.fromJson(guestsJson, typeOfGuestList);
       HashMap<Integer, Guest> guestMap = new HashMap<>();
       for(Guest g : guests){
           guestMap.put(g.getId(), g);


       }

       Type typeOfMessageList = new TypeToken<List<Message>>(){}.getType();
       List<Message> messages = gson.fromJson(messageJson, typeOfMessageList);
       HashMap<Integer, Message> messageMap = new HashMap<>();
       for(Message m : messages){
           messageMap.put(m.getId(), m);

       }
        int hotel_id = 0;
       Scanner scanner = new Scanner(System.in);
        int counter = 0;
       do{


         if(counter > 0){
             System.out.println("Invalid hotel id entered. \nHotel Legend:");
             for(int id : companyMap.keySet()){
                   System.out.print("(" + id + ") " + companyMap.get(id).getCompany() + ", ");
              }
              System.out.print("\n");

         }
           System.out.println("Please enter a hotel id:");
           String input = scanner.next();

           boolean isvalid = Util.checkIntInput(input, companyMap.keySet());
           if(isvalid == true){
               hotel_id = Integer.parseInt(input);

           }
           counter++;

       }while(hotel_id <= 0);


        int guest_id = 0;
        counter = 0;
        do{


            if(counter > 0){
                System.out.println("Invalid guest id entered. \nGuest Listing:");
                for(int id : companyMap.keySet()){
                    System.out.print("(" + id + ") " + guestMap.get(id).getLastName() + ", " + guestMap.get(id).getFirstName() + ". ");
                }
                System.out.print("\n");

            }
            System.out.println("Please enter a guest id:");
            String input = scanner.next();

            boolean isvalid = Util.checkIntInput(input, guestMap.keySet());
            if(isvalid == true){
                guest_id = Integer.parseInt(input);

            }
            counter++;

        }while(guest_id <= 0);



int message_id = 0;
do {
    System.out.println("Please enter the message id or enter a custom message with the following placeholders: **greeting**, **customer_name**, **hotel_name**, **room_number**, **start_time** and **end_time**: ");
    Scanner linescanner = new Scanner(System.in).useDelimiter("\\n");
    String input = linescanner.next();

    try {
        int inp = Integer.parseInt(input);
        if(messageMap.get(inp) != null){
            message_id = inp;

        }

    } catch (NumberFormatException e) {
        int key = messageMap.size();
        Message custommessage = new Message(key, input);
        messageMap.put(key, custommessage);
        message_id = key;

    }
}while(message_id <= 0);
        String greeting = Util.getGreeting(companyMap.get(hotel_id).getTimezone());
        Request request = new Request(greeting, companyMap.get(hotel_id), guestMap.get(guest_id), messageMap.get(message_id));
        String template = Util.processRequest(request);
        return template;


    }


}