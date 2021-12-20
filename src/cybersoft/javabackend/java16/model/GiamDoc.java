package cybersoft.javabackend.java16.model;

import java.util.Scanner;

public class GiamDoc extends NhanSu {
	private float soCoPhan;
	
	public float getSoCoPhan() {
		return soCoPhan;
	}
	public void setSoCoPhan(float soCoPhan) {
		this.soCoPhan = soCoPhan;
	}
	@Override
	public void nhapThongTin(Scanner sc) {
		super.nhapThongTin(sc);
		System.out.print("Nhập số cổ phần(%): ");
		while(!validateCoPhan(Float.parseFloat(sc.nextLine()),sc));
	}
	public boolean validateCoPhan(float num,Scanner sc) {
		if(num <= 100 && num >= 0) {
			this.soCoPhan = num;
			return true;
		}
		System.out.print("Nhập lỗi!!");
		System.out.print("Nhập lại số cổ phần: ");
		return false;
	}

	@Override
	public void xuatThongTin() {
		System.out.println("\n\t==> Giám Đốc <==");
		super.xuatThongTin();
		String thongTin = new StringBuilder()
				.append("\tSố cổ phần:").append(this.soCoPhan)
				.append("%")
				.toString();
		System.out.println(thongTin);
	}
	@Override
	public double tinhLuong() {
		return luongMotNgayLam*soNgayLam;
	}
	//xuất lương 
	@Override
	public void xuatLuong() {
		this.xuatThongTin();
		System.out.println(new StringBuilder().append("Lương: ").append(tinhLuong()));
	}

	//Tính thu nhập
	public double tinhThuNhap(double total,double doanhThuThang) {
		return tinhLuong() + (soCoPhan / 100)*(doanhThuThang - total);
	}
	//Xuất doanh Thu
	public void xuatThuNhap(double total,double doanhThuThang) {
		xuatThongTin();
		System.out.println(new StringBuilder()
				.append("\t=>Thu Nhập: ")
				.append(tinhThuNhap(total,doanhThuThang))
				.toString()
				);
	}
	
}
