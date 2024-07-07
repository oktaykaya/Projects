import java.util.Collections;
public class CarWasher {

    static double[] Carwasher_x_coordinates={15, 3, 31, 49, 18, 1, 43, 91, 7, 13, 56, 67};

    static double[] Carwasher_y_coordinates={88, 41, 56, 5, 64, 2, 23, 51, 89, 33, 35, 43};


    static String[] name_array={

            "Anadolu Carwasher","Torn Carwasher","Otantik Carwasher","Elitok Carwasher","Attractive Carwasher",
            "Positive Carwasher","Pars Carwasher","Nostalji Carwasher","Devil Carwasher",
            "Oktay's Carwasher", "Cengizhan Carwasher","Cagla Carwasher" };

    static String[] adressa={

        "Ankara","Ankara","İstanbul","İzmir","Ordu","Bursa","Antalya","Denizli","Bolu","Diyarbakır","Konya","Muğla"};

    static String[] address={

            "Aşikpaşa , Acin Street , No : 49 , Ankara",
            "Bademlidere , Semsettin Günaltay Street , No : 47/A , Ankara",
            "Murat , Bağlar Street , No: 225 , İstanbul",
            "Asikpasa , Ziya Oralay Street , No : 136/A, İzmir ",
            "Kırkkonaklar , 290. Street , No : 23 , Ordu",
            "Asikpasa , Yavuzevler Street , No 55 , Bursa  ",
            "Türközü , 433. Street , No : 7/A , Antalya ",
            "Sanayi , Anadolu Street , No : 11 , Denizli ",
            "İstiklal , Sirin Street , No : 1 , Bolu",
            "Haci Ali Bey, Ferahiye Street , No : 5 , Diyarbakır ",
            "Erenköy , Yildirim Street , No : 72 , Konya",
            "Ertugrulgazi , Cilem Street , No : 48 , Muğla"};
    static String[] phone_number = {

            "0543 536 07 26","0541 678 48 87","0546 005 00 05","(0222) 335 40 40","0546 240 29 07","0535 881 81 36",
            "(0222) 333 08 18","(0222) 233 70 74","0533 506 09 04","0536 943 73 74","(0222) 226 37 56","0552 405 05 89"

    };
    static String[] working_hours={

            "Monday to Saturday 08:00 am to 21.30 pm",
            "Monday to Saturday 09:00 am to 22.00 pm",
            "Monday to Sunday 10:00 am to 21.00 pm",
            "Monday to Saturday 10:00 am to 23.00 pm",
            "Monday to Friday 06:00 am to 18.00 pm",
            "Monday to Sunday 07:00 am to 19.00 pm",
            "Monday to Saturday 07:00 am to 18.30 pm",
            "Monday to Saturday 08:30 am to 20.45 pm",
            "Monday to Sunday 09:30 am to 21.00 pm",
            "Monday to Saturday 08:00 am to 19.30 pm",
            "Monday to Saturday 08:00 am to - (24 hours open)",
            "Monday to Saturday 08:00 am to 19.35 pm"

    };

    public static void listInfo(){

        System.out.println("\nAccording to your information, the 3 closest car washes are shown to you. ");

        Location.calculateDistance();

        //lists in order from near to far
        Collections.sort(Location.list);

        //lists the top 3 car washes
        for(int i =0;i<3;i++){
            System.out.println("\t"+Location.information.get(Location.list.get(i)));
        }
    }
    public static void list(){
        //lists the all car washer
        for (int i = 0; i < name_array.length; i++) {
            System.out.println(i+ " " +name_array[i]);
        }
    }
}
