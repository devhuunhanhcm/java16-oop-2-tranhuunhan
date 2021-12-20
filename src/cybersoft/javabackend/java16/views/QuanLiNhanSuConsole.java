package cybersoft.javabackend.java16.views;

import java.util.Scanner;

import cybersoft.javabackend.java16.controllers.QuanLiNhanSu;
import cybersoft.javabackend.java16.model.GiamDoc;
import cybersoft.javabackend.java16.model.NhanSu;
import cybersoft.javabackend.java16.model.NhanVien;
import cybersoft.javabackend.java16.model.TruongPhong;

public class QuanLiNhanSuConsole {
	private QuanLiNhanSu controller;
	private Scanner sc = new Scanner(System.in);

	public QuanLiNhanSuConsole() {
		controller = new QuanLiNhanSu();
	}

	public void start() {
		int option;
		do {
			inMenu();
			option = Integer.parseInt(sc.nextLine());
		}while(xyLyMenu(option));
	}

	public void inMenu() {
		System.out.print(new StringBuilder()
				.append("\n========================>([^-^])<========================\n")
				.append("                           Menu                           ")
				.append("\n\t1. Nhập thông tin công ty")
				.append("\n\t2. Xuất thông tin Công ty")
				.append("\n\t3. Thêm thông tin một nhân sự")
				.append("\n\t4. Phân bổ nhân viên vào Trưởng Phòng")
				.append("\n\t5. Xóa thông tin một nhân sự")
				.append("\n\t6. Xuất ra thông tin toàn bộ người trong công ty")
				.append("\n\t7. Xuất tổng lương cho toàn công ty")
				.append("\n\t8. Tìm Nhân viên thường có lương cao nhất")
				.append("\n\t9. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất")
				.append("\n\t10. Sắp xếp nhân viên toàn công ty theo thứ tự abc ")
				.append("\n\t11. Tìm Giám Đốc có số lượng cổ phần nhiều nhất")
				.append("\n\t12. Tính và Xuất tổng THU NHẬP của từng Giám Đốc")
				.append("\n\t0.Thoát")
				.append("\nChọn: ")
				.toString());
	}

	public boolean xyLyMenu(int option) {
		boolean isContinue = true;
		switch(option) {
		case 1:
			controller.nhapThongTinCongTy(sc);
			break;
		case 2:
			controller.xuatThongTinCongTy(sc);
			break;
		case 3: // thêm nhân sự
			themNhanSu();
			break;
		case 4: // phân bổ nhân sự
			NhanVien nv = controller.chonNhanVien(sc);
			TruongPhong tp = controller.chonTruongPhong(sc);
			if(nv != null && tp != null) {
				controller.phanBoNhanVienChoTp(nv, tp);
			}
			
			break;
		case 5://xóa nhân sự
			xoaNhanSu();
			break;
		case 6://xuất tất cả danh sách
			controller.xuatDanhSach();
			break;
		case 7://xuất tổng lương
			controller.xuatLuong();
			break;
		case 8:
			controller.xuatLuongNhanVienMax();
			break;
		case 9:
			controller.xuatTruongPhongNhieuNv();
			break;
		case 10:
			controller.sapXepThongTinTheoTen();
			break;
		case 11:
			controller.timGiamDocCoPhanHighest();
			break;
		case 12:
			controller.tongThuNhapGiamDoc();
			break;
		case 0:
			isContinue = false;
			break;
		default:
			System.err.println("Lựa chọn không hợp lệ.");
			break;
		}
		return isContinue;
	}

	
	private void xoaNhanSu() {
		System.out.println("==> Xóa Nhân sự <==");
		String maSo;
		System.out.print("==> Nhập mã số của nhân sự: ");
		maSo = sc.nextLine();
		controller.xoa(maSo);
	}

	private void themNhanSu() {
		System.out.print(new StringBuilder()
				.append("\nLoại nhân viên")
				.append("\n\t1.Nhân viên")
				.append("\n\t2.Trưởng phòng")
				.append("\n\t3.Giám đốc")
				.append("\nChọn: ")
				.toString());
		
		NhanSu nhansu;
		switch(Integer.parseInt(sc.nextLine())) {
		case 1: 
			nhansu = new NhanVien();
			break;
		case 2: 
			nhansu = new TruongPhong();
			break;
		case 3: 
			nhansu = new GiamDoc();
			break;
		default:
			System.out.println("Loại nhân sự không hợp lệ!");
			return;
		}
		nhansu.nhapThongTin(sc);
		controller.them(nhansu);
	}
}





