import java.io.*;
import java.util.Scanner;

public class Arquivo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            RandomAccessFile file = new RandomAccessFile("valores.dat", "rw");

            for (int i = 0; i < n; i++) {
                double num = scanner.nextDouble();
                file.writeDouble(num);
            }

            file.close();
            file = new RandomAccessFile("valores.dat", "r");

            long pointer = file.length();

            for (int i = 0; i < n; i++) {
                pointer -= 8;
                file.seek(pointer);
                double value = file.readDouble();

                if (value == (int) value) {
                    System.out.println((int) value);
                } else {
                    System.out.println(value);
                }
            }

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
