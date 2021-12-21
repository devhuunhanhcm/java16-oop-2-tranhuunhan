package cybersoft.javabackend.java16.model;

import java.util.Scanner;

public class NhanSu {
	protected String maSo;
	protected String name;
	protected String soDienThoai;
	protected float soNgayLam;
	protected float luongMotNgayLam;
	
	
	public NhanSu() {
		this.maSo = "";
	}
	public double tinhLuong() {
		return -1;
	}
	public void xuatLuong() {
	}
	public void xuatThongTin() {
		//dùng stringbuilder để đỡ tốn tài nguyên hơn
		String thongTin = new StringBuilder()
						.append("\tMã số: " ).append(this.maSo)
						.append("\n\tHọ tên: " ).append(this.name)
						.append("\n\tSố điện thoại: ").append(this.soDienThoai)
						.append("\n\tSố ngày làm: ").append(this.soNgayLam)
						.append("\n\tLương một ngày: " ).append(this.luongMotNgayLam)
						.toString();
		System.out.println(thongTin);
						
	}
	public void nhapThongTin(Scanner sc) {
		System.out.println("==>Nhập thông tin<==");
		System.out.print("Nhập mã số: ");
		this.maSo = sc.nextLine();
		System.out.print("Nhập họ tên: ");
		this.name = sc.nextLine();
		System.out.print("Nhập Số điện thoại: ");
		this.soDienThoai = sc.nextLine();
		System.out.print("Nhập số ngày làm: ");
		this.soNgayLam =handleInput(Float.parseFloat(sc.nextLine()),sc,"ngày làm");
		System.out.print("Nhập lương một ngày làm: ");
		this.luongMotNgayLam = handleInput(Float.parseFloat(sc.nextLine()),sc,"lương");
		
	}
	public float handleInput(float input,Scanner sc,String type) {
		while(input < 0) {
			System.out.print(new StringBuilder()
					.append("Nhập lỗi!Nhập lại số ")
					.append(type)
					.append(": ")
					.toString());
			input = Float.parseFloat(sc.nextLine());
		}
		return input;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getMaSo() {
		return maSo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
