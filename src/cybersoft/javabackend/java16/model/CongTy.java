package cybersoft.javabackend.java16.model;

import java.util.Scanner;

public class CongTy {
	/* properties */
	private String name;
	private String maSoThue;
	private double doanhThuThang;
	
	public CongTy() {
		this.doanhThuThang = 0;
	}

	public void nhapThongTinCongTy(Scanner sc) {
		System.out.println("===> Nhập thông tin công ty <===");
		System.out.print("Tên: ");
		this.name = sc.nextLine();
		System.out.print("Mã số thuế: ");
		this.maSoThue = sc.nextLine();
		System.out.print("Doanh thu tháng: ");
		this.doanhThuThang = Float.parseFloat(sc.nextLine());
	}

	public void xuatThongTinCongTy(Scanner sc) {
		System.out.print(new StringBuilder()
				.append("===> Thông Tin Công Ty <===")
				.append("\nTên: ").append(this.name)
				.append("\nMã số thuế: ").append(this.maSoThue)
				.append("\nDoanh thu tháng: ").append(this.doanhThuThang)
				.toString());
	}

	public double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}
	

}
