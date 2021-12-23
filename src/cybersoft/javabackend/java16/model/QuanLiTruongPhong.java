package cybersoft.javabackend.java16.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLiTruongPhong {
	private List<TruongPhong> danhSachTruongPhong;

	public QuanLiTruongPhong() {
		danhSachTruongPhong = new ArrayList<TruongPhong>();
	}

	public void xuatTruongPhong() {
		for (TruongPhong truongPhong : danhSachTruongPhong) {
			truongPhong.xuatThongTin();
		}
	}

	public TruongPhong chonTruongPhong(Scanner sc) {
		int i = 1;
		int choose;
		if(danhSachTruongPhong.isEmpty()) {
			System.out.println("==> Không có Trường phòng nào!Hãy thêm trưởng phòng.");
			return null;
		}
		for (TruongPhong tp : danhSachTruongPhong) {
			tp.chonTruongPhong(i);
			i++;
		}
		System.out.print("\n==>Chọn trưởng phòng số: ");
		choose = Integer.parseInt(sc.nextLine());
		while (choose < 0 || choose > danhSachTruongPhong.size()) {
			System.err.println("Chọn trưởng phòng không tồn tại!!");
			System.out.print("Chọn lại trưởng phòng số: ");
			choose = Integer.parseInt(sc.nextLine());
		}
		return danhSachTruongPhong.get(choose - 1);
	}

	public boolean them(TruongPhong ns) {
		return danhSachTruongPhong.add(ns);
	}

	public void xoaTruongPhong(TruongPhong tp) {
		List<NhanVien> danhSachNhanVien = tp.getDanhSachNhanVien();
		/*xóa nhân viên đc quản lí */
		if(danhSachNhanVien.size() > 0) {
			for (NhanVien nv : danhSachNhanVien) {
				nv.setTruongPhongQuanLy(null);
			}
			danhSachNhanVien.clear();
			System.out.println("==> xóa nhân viên quản lí");
		}
		danhSachTruongPhong.remove(tp);
		System.out.println("==> Xóa trưởng phòng trong Danh Sách");
	}

	public void xoaNhanVien(TruongPhong tp, NhanVien nv) {
		for (TruongPhong truongPhong : danhSachTruongPhong) {
			if (truongPhong.equals(tp)) {
				truongPhong.xoaNhanVienQuanLi(nv);
			}
		}
	}

	public void truongPhongNhieuNv() {
		if(danhSachTruongPhong.isEmpty()) {
			System.err.println("==> Không có trưởng phòng!Hãy thêm trưởng phòng.");
			return;
		}
		TruongPhong truongPhong = danhSachTruongPhong.get(0);
		int count = danhSachTruongPhong.get(0).getSoNhanVien();
		for (TruongPhong tp : danhSachTruongPhong) {
			if(tp.getSoNhanVien() > count) {
				truongPhong = tp;
			}
		}
		truongPhong.xuatThongTin();
	}
	
	//xóa nhân viên cũ của trưởng phòng khi mà gán cho nhân viên trưởng phòng mới
	public void xoaTruongPhongCu(NhanVien nv) {
		for (TruongPhong truongPhong : danhSachTruongPhong) {
			if(truongPhong.xoaNhanVienQuanLi(nv)) {
				System.out.println("==> xóa thành công!!");
				return;
			}
		}
	}

}
