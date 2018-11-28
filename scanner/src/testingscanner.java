import java.util.Scanner;

public class testingscanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String data;
//        do {
//            data = sc.next();
//            if (data.matches("^[\\d]+$")) {
//                System.out.println(data);
//            } else if(data.equalsIgnoreCase("stop")){
//               break;
//            }else {
//                System.out.println("data");
//            }
//        } while(true);
        String a = sc.next();
        boolean t = a.matches("[\\d]+([.]\\d+)*");//("^((\\w*(-*)\\w*)&&(\\S))$");
        System.out.println(t + "   " + Double.parseDouble(a));
    }
}
