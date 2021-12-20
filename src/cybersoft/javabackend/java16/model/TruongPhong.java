package cybersoft.javabackend.java16.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruongPhong extends NhanSu {
	private int soNhanVien;
	private List<NhanVien> danhSachNhanVien;
	
	
	public TruongPhong() {
		danhSachNhanVien = new ArrayList<NhanVien>();
		this.soNhanVien = danhSachNhanVien.size();
	}
	//thêm nhân viên vào danhSachNhanVien
	public void themNhanVien(NhanVien nv) {
		if(nv.getMaSo() == null || nv.getMaSo().equals("")) {
			System.out.println("Nhân viên không tồn tại!!");
			return;
		}
		danhSachNhanVien.add(nv);
		System.out.println("Thêm nhân viên thành công!!");
		this.soNhanVien ++;
	}
	@Override
	public void xuatThongTin() {
		System.out.println("\n\t==> Trưởng Phòng <==");
		super.xuatThongTin();
		System.out.println(new StringBuilder()
				.append("\tSố nhân viên quản lí: ")
				.append(this.soNhanVien)
				.toString());
	}
	//xuất bảng chọn trưởng phòng
	public void chonTruongPhong(int i) {
		String chonTruongPhong = new StringBuilder()
						.append("\n[").append(i).append("] TP [")
						.append("Tên: ").append(this.name)
						.append(",Mã Số: ").append(this.maSo)
						.append(",Số nhân viên quản lí: ").append(this.soNhanVien)
						.append(" ]")
						.toString();
		System.out.print(chonTruongPhong);
	}
	@Override
	public double tinhLuong() {
		return soNgayLam*luongMotNgayLam + 100*soNhanVien;
	}
	//xóa nhân viên
	public boolean xoaNhanVienQuanLi(NhanVien nv) {
		for (NhanVien nhanVien : danhSachNhanVien) {
			if(nhanVien.equals(nv)) {
				danhSachNhanVien.remove(nv);
				System.out.println("Xóa sinh viên được quản lí.");
				this.soNhanVien--;
				return true;
			}
		}
		return false;
	}
	//xuất lương 
	@Override
	public void xuatLuong() {
		this.xuatThongTin();
		System.out.println(new StringBuilder().append("Lương: ").append(tinhLuong()));
	}
	
	
	
	public int getSoNhanVien() {
		return soNhanVien;
	}
	public void setSoNhanVien(int soNhanVien) {
		this.soNhanVien = soNhanVien;
	}
	public List<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}
	public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}
	
	
	
}
