package cybersoft.javabackend.java16.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLiNhanVien {
	private List<NhanVien> danhSachNhanVien;

	public QuanLiNhanVien() {
		danhSachNhanVien = new ArrayList<NhanVien>();
	}
	//thêm nhân viên 
	public boolean themNhanVien(NhanVien nv) {
		return danhSachNhanVien.add(nv);
	}
	
	
	//Xuất bảng chọn nhân viên 
	public NhanVien xuatChonNhanVien(Scanner sc) {
		int i = 1;
		int choose;
		if(danhSachNhanVien.isEmpty()) {
			System.out.println("==> Không có nhân viên nào!Hãy thêm nhân viên");
			return null;
		}
		for (NhanVien nhanVien : danhSachNhanVien) {
			nhanVien.chonNhanVien(i);
			i++;
		}
		System.out.print("\n==> Chọn nhân viên số: ");
		choose = Integer.parseInt(sc.nextLine()) ;
		while(choose < 0 || choose > danhSachNhanVien.size()) {
			System.err.println("Chọn nhân viên không tồn tại!!");
			System.out.print("==> Chọn lại nhân viên số: ");
			choose = Integer.parseInt(sc.nextLine());
		}
		
		return danhSachNhanVien.get(choose -1);
		
	}
	
	//xóa nhân viên trả về thằng trưởng phòng của nó
	public TruongPhong xoaNhanVien(NhanVien nv) {
		TruongPhong truongPhong = null;
		if(nv.getTruongPhongQuanLy().maSo != null) {
			truongPhong = nv.getTruongPhongQuanLy();
		}
		danhSachNhanVien.remove(nv);
		System.out.println("==> Xóa nhân viên");
		return truongPhong;
	}
	public void xuatLuongCaoNhat() {
		if(danhSachNhanVien.isEmpty()) {
			System.err.println("Không có nhân viên nào!Hãy thêm nhân viên.");
			return;
		}
		System.out.println("==>Nhân viên thường có lương cao nhất<==");
		double luongMax = danhSachNhanVien.get(0).tinhLuong();
		for (NhanVien nhanVien : danhSachNhanVien) {
			if(nhanVien.tinhLuong() > luongMax) {
				luongMax = nhanVien.tinhLuong();
			}
		}
		for (NhanVien nhanVien : danhSachNhanVien) {
			if(nhanVien.tinhLuong() == luongMax) {
				nhanVien.xuatLuong();
			}
		}
	}
}
