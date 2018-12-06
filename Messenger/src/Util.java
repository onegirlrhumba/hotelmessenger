import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Util {

    public static String getGreeting(String timezone){
        String greeting = "Greetings";
        ZoneId zone = ZoneId.of(timezone);
        LocalDateTime now = LocalDateTime.now(zone);

        if(now.getHour() < 12 && now.getHour() > 4){
            greeting = "Good Morning";
        }else if(now.getHour() >= 12 && now.getHour() < 16){
            greeting = "Good Afternoon";
        }else{
            greeting = "Good Evening";
        }
        return greeting;
    }
    public static String processRequest(Request request){

        String template = request.getMessage().getMessage();
        template = template.replace("**greeting**", request.getGreeting());

        template = template.replace("**customer_name**", request.getGuest().getFirstName() + " " + request.getGuest().getLastName());
        template = template.replace("**hotel_name**", request.getCompany().getCompany());
        template = template.replace("**room_number**", request.getGuest().getReservation().get("roomNumber").toString());
        template = template.replace("**start_time**", convertTimeStamp(request.getGuest().getReservation().get("startTimestamp"), request.getCompany().getTimezone()));
        template = template.replace("**end_time**", convertTimeStamp(request.getGuest().getReservation().get("endTimestamp"), request.getCompany().getTimezone()));
        return template;


    }
    public static String convertTimeStamp(Long timestamp, String timezone){
        ZoneId zone = ZoneId.of(timezone);
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), zone);
        return dateTime.format(DateTimeFormatter.ofPattern("hh:mm a MM-dd-yyyy"));

    }
    public static boolean checkIntInput(String input, Set<Integer> keys){
        boolean result = true;
        try{
            int inp = Integer.parseInt(input);
            if(!keys.contains(inp)){
                result = false;
            }

        }catch(Exception e){
            result = false;

        }
        return result;


    }
    public static void main(String[] args) {
        System.out.println(convertTimeStamp(1486852373L, "US/Eastern"));
    }
}
