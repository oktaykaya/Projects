import java.util.Scanner;

public class ReservationHistory extends CarWasher{

public static void make_reservation(){
    System.out.println("************************************************************************************************************");
    CarWasher.list();
    System.out.println("************************************************************************************************************");
    System.out.println("please choose a carwasher");
    Scanner scanner = new Scanner(System.in);
    String name = "Oktay's Carwasher";
    Search.search_name(name);
    System.out.println("resarvation has been done.");
    Coupon.givecoupon();

}

}
