package Client;

import java.util.*;

class AutoSlot {
    static int first, second, third;

    public static void main(String[] args) {
        slot();
        while (slotExit()) {
            slot();
        }
    }

    public static void slot() {
        System.out.println("3개의 숫자를 입력하십시오.");
        Random random = new Random();
        first = random.nextInt(9);
        second = random.nextInt(9);
        third = random.nextInt(9);
        System.out.printf("숫자들: %d\t%d\t%d\n", first, second, third);
        slotPlay(first, second, third);
    }

    public static void slotPlay(int a, int b, int c) {
        if (a == b && b == c) {
            System.out.println("1등 당첨");
        } else if (a != b && b != c) {
            System.out.println("꽝");
        } else {
            System.out.println("2등 당첨");
        }
    }

    public static boolean slotExit() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("게임 계속?(예 혹은 아니오)");
            String s = sc.nextLine();
            if (s.equals("예")) {
                return true;
            } else if (s.equals("아니오")) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}


