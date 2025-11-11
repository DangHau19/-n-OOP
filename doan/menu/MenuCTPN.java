package doan.menu;

import java.util.*;
import doan.single.CTPN;
import doan.list.DSCTPN;

public class MenuCTPN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSCTPN ds = new DSCTPN();
        int chon;

        do {
            System.out.println("\n===== MENU CHI TIET PHIEU NHAP =====");
            System.out.println("1. Nhap danh sach chi tiet phieu nhap");
            System.out.println("2. Xuat danh sach chi tiet phieu nhap");
            System.out.println("3. Them chi tiet phieu nhap");
            System.out.println("4. Xoa chi tiet phieu nhap theo ma");
            System.out.println("5. Sua thong tin chi tiet phieu nhap theo ma");
            System.out.println("6. Tim chi tiet phieu nhap theo ma CTPN");
            System.out.println("7. Tim chi tiet phieu nhap theo ma phieu");
            System.out.println("8. Thong ke tong tien theo ma phieu");
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
                    CTPN ctpn = new CTPN();
                    ctpn.nhap();
                    ds.them(ctpn);
                    System.out.println("Them chi tiet phieu nhap thanh cong!");
                }
                case 4 -> {
                    System.out.print("Nhap ma chi tiet phieu nhap can xoa: ");
                    String maXoa = sc.nextLine();
                    ds.xoa(maXoa);
                }
                case 5 -> {
                    System.out.print("Nhap ma chi tiet phieu nhap can sua: ");
                    String maSua = sc.nextLine();
                    ds.sua(maSua);
                }
                case 6 -> {
                    System.out.print("Nhap ma chi tiet phieu nhap can tim: ");
                    String ma = sc.nextLine();
                    ds.timTheoMaCTPN(ma);
                }
                case 7 -> {
                    System.out.print("Nhap ma phieu can tim: ");
                    String ma = sc.nextLine();
                    ds.timTheoMaPhieu(ma);
                }
                case 8 -> {
                    System.out.print("Nhap ma phieu can thong ke tong tien: ");
                    String maPhieu = sc.nextLine();
                    ds.thongKeTongTienTheoPhieu(maPhieu);
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