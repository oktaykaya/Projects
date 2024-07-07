import java.util.Scanner;

public class Application {

    static String CAREZ = "        CAREZ \n" +
                          "Car Washer Reservation";

    static String closing_line = "Have a good day";

    static String login = "Carez@hotmail.com";
    static String loginPhone ="5424861578";

    public static void loginn(String log){
        if (log == login){
            System.out.println("welcome to CAREZ");
        }
        else if (log == "5424861578"){
            System.out.println("welcome to CAREZ");
        }
        else{
            System.out.println("you entered wrong thing...");
        }
    }


    public static void open() {
        System.out.println("\n"+CAREZ );
    }

    public static void close() {
        System.out.println("\n" + closing_line);
    }


    public static void main(String[] args){
        open();
        loginn(login);
        loginn(loginPhone);
        CarWasher.list();
        CarWasher.listInfo();
        Search.search_name("Anadolu Carwasher");
        Search.search_area("Ankara");
        ReservationHistory.make_reservation();
        close();
    }
}
