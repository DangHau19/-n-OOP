package doan.list;

import java.io.*;
import java.util.*;
import doan.single.NCC;

public class DSNCC {
    private NCC[] ds = new NCC[0];

    public void nhapDanhSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nha cung cap: ");
        int n = sc.nextInt();
        sc.nextLine();
        ds = new NCC[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap nha cung cap thu " + (i + 1));
            ds[i] = new NCC();
            ds[i].nhap();
        }
    }

    public void xuatDanhSach() {
        System.out.printf("%-10s %-20s %-20s %-15s %-15s\n",
                "MaNCC", "TenNCC", "DiaChi", "SDT", "TenSP");
        for (NCC ncc : ds)
            ncc.xuat();
    }

    public void them(NCC ncc) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = ncc;
    }

    public void xoa(String ma) {
        int index = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaNCC().equalsIgnoreCase(ma)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("\nKhong tim thay ma nha cung cap can xoa!");
            return;
        }
        for (int i = index; i < ds.length - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, ds.length - 1);
        System.out.println("\nDa xoa nha cung cap co ma " + ma);
    }

    public void sua(String maNCC) {
    for (int i = 0; i < ds.length; i++) {
        if (ds[i].getMaNCC().equalsIgnoreCase(maNCC)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Sua ten nha cung cap\n2. Sua dia chi\n3. Sua so dien thoai\n4. Sua ten san pham");
            System.out.print("Sua thong tin so: ");
            int chon = sc.nextInt();
            sc.nextLine();
                switch (chon) {
                    case 1 -> { System.out.print("Nhap ten nha cung cap moi: "); ds[i].setTenNCC(sc.nextLine()); }
                    case 2 -> { System.out.print("Nhap dia chi moi: "); ds[i].setDiaChi(sc.nextLine()); }
                    case 3 -> { System.out.print("Nhap so dien thoai moi: "); ds[i].setSoDienThoai(sc.nextLine()); }
                    case 4 -> { System.out.print("Nhap ten san pham moi: "); ds[i].setTenSanPham(sc.nextLine()); }
                    default -> System.out.println("Lua chon khong hop le!");
                }
                return;
            }
        }
        System.out.println("\nKhong tim thay ma nha cung cap!");
    }

    public void timTheoSanPham(String sp) {
        System.out.println("\nCac nha cung cap co san pham \"" + sp + "\":");
        boolean found = false;
        for (NCC ncc : ds)
            if (ncc.getTenSanPham().equalsIgnoreCase(sp)) {
                ncc.xuat();
                found = true;
            }
        if (!found) System.out.println("\nKhong tim thay san pham nao trung khop!");
    }

    public void timTheoDiaChi(String dc) {
        System.out.println("\nCac nha cung cap o dia chi \"" + dc + "\":");
        boolean found = false;
        for (NCC ncc : ds)
            if (ncc.getDiaChi().equalsIgnoreCase(dc)) {
                ncc.xuat();
                found = true;
            }
        if (!found) System.out.println("\nKhong tim thay dia chi nao trung khop!");
    }

    // Thống kê số lượng công ty ở địa chỉ ...
    public void thongKeSoLuongTheoDiaChi(String dc) {
        int dem = 0;
        for (NCC ncc : ds)
            if (ncc.getDiaChi().equalsIgnoreCase(dc))
                dem++;
        System.out.println("\nSo luong cong ty o dia chi \"" + dc + "\": " + dem);
    }
}
