import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Location extends CarWasher {

    static Double[] distance=new Double[12];
    static double x_coordinates = (Math.random() * 100);
    static double y_coordinates = (Math.random() * 100);
    static ArrayList list=new ArrayList();
    static LinkedHashMap information =new LinkedHashMap();

    public static void calculateDistance() {
        //will take input from Carwasher coordinates
        for (int i = 0; i < 12; i++) {
            distance[i] = Math.pow((Math.pow(Carwasher_x_coordinates[i] - x_coordinates, 2) +
                    Math.pow(Carwasher_y_coordinates[i] - y_coordinates, 2)), 0.5);
            list.add(distance[i]);
            information.put(distance[i],"Name: "+name_array[i]+"  Address: "+address[i]+
                    " Telephone Number: "+phone_number[i]+" Working Hours: "+working_hours[i]);
        }
    }
}