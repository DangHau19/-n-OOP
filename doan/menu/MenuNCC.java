package doan.menu;

import java.util.Scanner;

import doan.list.DSNCC;
import doan.single.NCC;

public class MenuNCC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSNCC ds = new DSNCC();
        int chon;
        do {
            System.out.println("\n===== MENU NHA CUNG CAP =====");
            System.out.println("1. Nhap danh sach nha cung cap");
            System.out.println("2. Xuat danh sach nha cung cap");
            System.out.println("3. Them nha cung cap");
            System.out.println("4. Xoa nha cung cap theo ma");
            System.out.println("5. Sua thong tin nha cung cap theo ma");
            System.out.println("6. Tim nha cung cap theo san pham ");
            System.out.println("7. Tim nha cung cap theo dia chi");
            System.out.println("8. Thong ke so luong cong ty theo dia chi");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> {
                    ds.nhapDanhSach();
                }
                case 2 -> {
                    ds.xuatDanhSach();
                }
                case 3 -> {
                    NCC ctpn = new NCC();
                    ctpn.nhap();
                    ds.them(ctpn);
                    System.out.println("Them nha cung cap thanh cong!");
                }
                case 4 -> {
                    System.out.print("Nhap ma nha cung cap can xoa: ");
                    String maXoa = sc.nextLine();
                    ds.xoa(maXoa);
                }
                case 5 -> {
                    System.out.print("Nhap ma nha cung cap can sua: ");
                    String maSua = sc.nextLine();
                    ds.sua(maSua);
                }
                case 6 -> {
                    System.out.print("Nhap san pham can tim: ");
                    String ma = sc.nextLine();
                    ds.timTheoSanPham(ma);
                }
                case 7 -> {
                    System.out.print("Nhap dia chi can tim: ");
                    String ma = sc.nextLine();
                    ds.timTheoDiaChi(ma);
                }
                case 8 -> {
                    System.out.print("Nhap dia chi can thong ke so nha cung cap: ");
                    String maPhieu = sc.nextLine();
                    ds.thongKeSoLuongTheoDiaChi(maPhieu);
                }
                case 0 -> {
                    System.out.println("Dang thoat chuong trinh...");
                }
                default -> {
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                }
            }
        } while (chon != 0);
    }
}
