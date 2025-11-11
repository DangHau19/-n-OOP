package doan.menu;

import doan.list.DSPN;
import doan.single.PN;
import java.util.Scanner;

public class MenuPN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSPN ds = new DSPN();
        int choice;
        do {
            System.out.println("===== MENU PHIEU NHAP =====");
            System.out.println("1. Nhap danh sach");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Them phieu nhap");
            System.out.println("4. Xoa phieu nhap theo ma");
            System.out.println("5. Sua phieu nhap theo ma");
            System.out.println("6. Tim phieu nhap theo ma");
            System.out.println("7. Tim phieu nhap theo ngay");
            System.out.println("8. Thong ke tong so luong theo ngay");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> ds.nhapDanhSach();
                case 2 -> ds.xuatDanhSach();
                case 3 -> {
                    PN p = new PN();
                    p.nhap();
                    ds.themPN(p);
                }
                case 4 -> {
                    System.out.print("Nhap ma can xoa: ");
                    ds.xoaPhieuNhapTheoMa(sc.nextLine());
                }
                case 5 -> {
                    System.out.print("Nhap ma can sua: ");
                    ds.suaPhieuNhap( sc.nextLine());
                }
                case 6 -> {
                    System.out.print("Nhap ma can tim: ");
                    ds.timTheoMa(sc.nextLine());
                }
                case 7 -> {
                    System.out.print("Nhap ngay can tim: ");
                    ds.timTheoNgay(sc.nextLine());
                }
                case 8 -> {
                    System.out.print("Nhap ngay can thong ke: ");
                    ds.thongKeTheoNgay(sc.nextLine());
                }
                case 0 -> System.out.println("Thoat chuong trinh.");
            }
        } while (choice != 0);
    }
}
