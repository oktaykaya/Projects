import java.util.LinkedHashMap;

public class Search extends CarWasher {

    public static void search_name(String name) {

        LinkedHashMap name_info = new LinkedHashMap();

        for (int i = 0; i < 12; i++) {
            name_info.put(name_array[i], "Name: " + name_array[i] + "  Address: " + address[i] +
                    "  Telephone Number: " + phone_number[i] + "  Working Hours: " + working_hours[i]);
        }

        if (name_info.containsKey(name)) {
            System.out.println("\nCar washes with wanted name found: \n\t" + name_info.get(name)+"\n");
        } else {
            System.out.println("\tCar washes with name " + name + " is not found. \n");
        }

    }

    public static void search_area(String area) {

        System.out.println("Car washes in searched state has found: ");

        for (int i = 0; i < 12; i++) {
            if (adressa[i].contains(area)){
                System.out.println("\tName: " + name_array[i] + "  Address: " + address[i] +
                        "  Telephone Number: " + phone_number[i] + "  Working Hours: " + working_hours[i]);
            }
        }
    }
}

