package doan.list;

import doan.single.PN;
import java.io.*;
import java.util.*;

public class DSPN {
    private PN[] ds = new PN[0];

    // Nhập danh sách
    public void nhapDanhSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phieu nhap: ");
        int n = sc.nextInt(); sc.nextLine();
        ds = new PN[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phieu nhap thu " + (i+1));
            ds[i] = new PN();
            ds[i].nhap();
        }
    }


    // Xuất danh sách
    public void xuatDanhSach() {
        System.out.printf("%-10s %-10s %-12s %-15s %-10s %-12s %-12s\n",
                "MaPN", "MaNCC", "NgayNhap", "TenHang", "SoLuong", "DonGia", "ThanhTien");
        for (PN p : ds) {
            p.xuat();
        }
    }

    // Thêm phiếu nhập
    public void themPN(PN p) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = new PN(p);
    }

    // Xóa phiếu nhập theo mã
    public void xoaPhieuNhapTheoMa(String ma) {
        int index = -1;
        for (int i = 0; i < ds.length; i++){
            if (ds[i].getMaPhieu().equalsIgnoreCase(ma)){ index = i; break;}}
        if (index == -1) {
            System.out.println("\nKhong tim thay ma phieu!");
            return;
        }
        for (int i = index; i < ds.length - 1; i++) 
        ds[i] = ds[i + 1];
        ds = Arrays.copyOf(ds, ds.length - 1);
        System.out.println("\nDa xoa phieu nhap co ma " + ma);
    }


    // Sửa phiếu nhập theo mã
    public void suaPhieuNhap(String maPhieu) {
    for (int i = 0; i < ds.length; i++) {
        if (ds[i].getMaPhieu().equalsIgnoreCase(maPhieu)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Sua ma nha cung cap\n2. Sua ngay nhap\n3. Sua ten hang\n4. Sua so luong\n5. Sua đon gia");
            System.out.print("Sua thong tin so: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1 -> { System.out.print("Nhap ma NCC moi: "); ds[i].setMaNhaCungCap(sc.nextLine()); }
                case 2 -> { System.out.print("Nhap ngay nhap moi: "); ds[i].setNgayNhap(sc.nextLine()); }
                case 3 -> { System.out.print("Nhap ten hang moi: "); ds[i].setTenHang(sc.nextLine()); }
                case 4 -> { System.out.print("Nhap so luong moi: "); ds[i].setSoLuong(sc.nextInt()); }
                case 5 -> { System.out.print("Nhap don gia moi: "); ds[i].setDonGia(sc.nextDouble()); }
                default -> System.out.println("Lua chon khong hop le!");
            }
            return;
        }
    }
    System.out.println("\nKhong tim thay phieu nhap can sua!");
}
    // Tìm kiếm theo mã
    public void timTheoMa(String ma) {
        for (PN p : ds) {
            if (p.getMaPhieu().equalsIgnoreCase(ma)) {
                p.xuat();
                return;
            }
        }
        System.out.println("\nKhong tim thay!");
    }

    //  Tìm kiếm theo ngày
    public void timTheoNgay(String ngay) {
        for (PN p : ds) {
            if (p.getNgayNhap().equals(ngay)) {
                p.xuat();
            }
        }
    }

    //  Thống kê tổng số lượng theo ngày
    public void thongKeTheoNgay(String ngay) {
        int tong = 0;
        for (PN p : ds) {
            if (p.getNgayNhap().equals(ngay)) {
                tong += p.getSoLuong();
            }
        }
        System.out.println("\nTong so luong ngay " + ngay + ": " + tong);
    }
}