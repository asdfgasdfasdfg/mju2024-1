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
        System.out.println("3���� ���ڸ� �Է��Ͻʽÿ�.");
        Random random = new Random();
        first = random.nextInt(9);
        second = random.nextInt(9);
        third = random.nextInt(9);
        System.out.printf("���ڵ�: %d\t%d\t%d\n", first, second, third);
        slotPlay(first, second, third);
    }

    public static void slotPlay(int a, int b, int c) {
        if (a == b && b == c) {
            System.out.println("1�� ��÷");
        } else if (a != b && b != c) {
            System.out.println("��");
        } else {
            System.out.println("2�� ��÷");
        }
    }

    public static boolean slotExit() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("���� ���?(�� Ȥ�� �ƴϿ�)");
            String s = sc.nextLine();
            if (s.equals("��")) {
                return true;
            } else if (s.equals("�ƴϿ�")) {
                return false;
            } else {
                System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
            }
        }
    }
}


