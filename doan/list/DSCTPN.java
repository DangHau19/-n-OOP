package doan.list;

import java.util.*;
import doan.single.CTPN;

public class DSCTPN {
    private CTPN[] ds = new CTPN[0];

    public void nhapDanhSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phieu nhap: ");
        int n = sc.nextInt(); sc.nextLine();
        ds = new CTPN[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phieu nhap thu " + (i+1));
            ds[i] = new CTPN();
            ds[i].nhap();
        }
    }

    public void xuatDanhSach() {
        System.out.printf("%-10s %-10s %-15s %-8s %-10s %-10s\n",
                "MaCTPN", "MaPN", "TenHang", "SL", "DonGia", "ThanhTien");
        for (CTPN c : ds) c.xuat();
    }

    public void them(CTPN ctpn) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = ctpn;
    }
 
    public void xoa(String ma) {
        int index = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaCTPN().equalsIgnoreCase(ma)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("\nKhong tim thay ma chi tiet phieu nhap can xoa!");
            return;
        }
        for (int i = index; i < ds.length - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, ds.length - 1);
        System.out.println("\nDa xoa chi tiet phieu nhap co ma " + ma);
    }

    public void sua(String maCTPN) {
    for (int i = 0; i < ds.length; i++) {
        if (ds[i].getMaCTPN().equalsIgnoreCase(maCTPN)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Sua ma phieu nhap\n2. Sua ten hang\n3. Sua so luong\n4. Sua don gia");
            System.out.print("Sua thong tin so: ");
            int chon = sc.nextInt();
            sc.nextLine();
                switch (chon) {
                    case 1 -> { System.out.print("Nhap ma phieu nhap moi: "); ds[i].setMaPhieu(sc.nextLine()); }
                    case 2 -> { System.out.print("Nhap ten hang moi: "); ds[i].setTenHang(sc.nextLine()); }
                    case 3 -> { System.out.print("Nhap so luong moi: "); ds[i].setSoLuong(sc.nextInt()); }
                    case 4 -> { System.out.print("Nhap don gia moi: "); ds[i].setDonGia(sc.nextDouble()); }
                    default -> System.out.println("Lua chon khong hop le!");
                }
                return;
            }
        }
        System.out.println("\nKhong tim thay ma chi tiet phieu nhap!");
    }
    public void timTheoMaCTPN(String ma) {
        for (CTPN c : ds)
            if (c.getMaCTPN().equalsIgnoreCase(ma)) c.xuat();
    }

    public void timTheoMaPhieu(String ma) {
        for (CTPN c : ds)
            if (c.getMaPhieu().equalsIgnoreCase(ma)) c.xuat();
    }

    public void thongKeTongTienTheoPhieu(String maPhieu) {
        double tong = 0;
        for (CTPN c : ds)
            if (c.getMaPhieu().equalsIgnoreCase(maPhieu)) tong += c.getThanhTien();
        System.out.println("\nTong tien cua phieu nhap " + maPhieu + ": " + tong);
    }
}