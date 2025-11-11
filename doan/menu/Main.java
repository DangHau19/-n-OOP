package doan.menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== MENU CHINH =====");
            System.out.println("1. Quan ly Phieu Nhap");
            System.out.println("2. Quan ly Chi Tiet Phieu Nhap");
            System.out.println("3. Quan ly Nha Cung Cap");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                   
                case 1 -> MenuPN.main(null);    
                case 2 -> MenuCTPN.main(null); 
                case 3 -> MenuNCC.main(null);
                case 0 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }
}