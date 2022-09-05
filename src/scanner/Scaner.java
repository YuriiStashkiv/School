package scanner;

import java.util.Scanner;

public class Scaner {
    private Scanner sc;

    public int anInt() {
        int value;
        sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Retry: ");
        }
        value = sc.nextInt();
        return value;
    }

    public byte anByte() {
        byte value;
        sc = new Scanner(System.in);
        while (!sc.hasNextByte()) {
            sc.next();
            System.out.print("Retry: ");
        }
        value = sc.nextByte();
        return value;
    }

    public String anString() {
        sc = new Scanner(System.in);
        String line;
        line = sc.nextLine();
        return line;
    }

    public double anDouble() {
        double value;
        sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.print("Retry: ");
        }
        value = sc.nextDouble();
        return value;
    }

}
