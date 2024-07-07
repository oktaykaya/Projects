public class Coupon {

    public static int coupon(){
        for (int i=1; i<2; i++){

             int number =  1+(int)(Math.random()* 3);
            return number;
        }
        return 0;
    }
    public static void givecoupon(){
        coupon();
        if (coupon() == 3){
            System.out.println("CONGRATULATİONS\n" +
                    "This is your 3rd reservation\n" +
                    "You've won a one-time free coupon.");
        }
        else {
            System.out.println("Do not forget to prefer us more to win coupons.");
        }
    }
}

