import java.util.*;

public class Deposit {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int twiceYear = 0;

        System.out.print("원금을 입력하세요: ");
        double principal = sc.nextDouble();
        System.out.println(principal);

        System.out.print("연이율을 입력하세요: ");
        double depositRate = sc.nextDouble();
        System.out.println(depositRate);

        System.out.println();

        System.out.println("연도수" + "\t" + "원리금");
        Double principalI = principal;
        while (principalI < principal * 2) {
            principalI = principalI + (principalI * depositRate / 100);
            twiceYear++;
            System.out.println(twiceYear + "\t" + principalI);
        }

        System.out.println("필요한 연도수: " + twiceYear);
    }
}
