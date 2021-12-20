package cybersoft.javabackend.java16.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import cybersoft.javabackend.java16.model.CongTy;
import cybersoft.javabackend.java16.model.GiamDoc;
import cybersoft.javabackend.java16.model.NhanSu;
import cybersoft.javabackend.java16.model.NhanVien;
import cybersoft.javabackend.java16.model.QuanLiGiamDoc;
import cybersoft.javabackend.java16.model.QuanLiNhanVien;
import cybersoft.javabackend.java16.model.QuanLiTruongPhong;
import cybersoft.javabackend.java16.model.TruongPhong;

public class QuanLiNhanSu {

	private List<NhanSu> danhSachNhanSu;
	private CongTy congTy;
	private QuanLiTruongPhong quanLiTruongPhong;
	private QuanLiNhanVien quanLiNhanVien;
	private QuanLiGiamDoc quanLiGiamDoc;

	public QuanLiNhanSu() {
		danhSachNhanSu = new ArrayList<NhanSu>();
		congTy = new CongTy();
		quanLiTruongPhong = new QuanLiTruongPhong();
		quanLiNhanVien = new QuanLiNhanVien();
		quanLiGiamDoc = new QuanLiGiamDoc();
	}

	public void nhapThongTinCongTy(Scanner sc) {
		congTy.nhapThongTinCongTy(sc);
	}

	public void xuatThongTinCongTy(Scanner sc) {
		congTy.xuatThongTinCongTy(sc);
	}

	public boolean them(NhanSu ns) {
		boolean isInstanceOf = true;
		// validate
		if (ns.getMaSo() == null || ns.getMaSo().equals("")) {
			return false;
		}
		// add in TruongPhong List
		if (isInstanceOf && ns instanceof TruongPhong) {
			quanLiTruongPhong.them((TruongPhong) ns);
			isInstanceOf = false;
		}
		// add in NhanVien List
		if (isInstanceOf && ns instanceof NhanVien) {
			quanLiNhanVien.themNhanVien((NhanVien) ns);
			isInstanceOf = false;
		}
		// add in GiamDoc List
		if (isInstanceOf && ns instanceof GiamDoc) {
			quanLiGiamDoc.themGiamDoc((GiamDoc) ns);
			isInstanceOf = false;
		}
		return danhSachNhanSu.add(ns);
	}

	// xóa bằng mã số của nhân sự
	public boolean xoa(String maSo) {
		boolean isFind = true;
		if (maSo == null || maSo.equals(""))
			return false;
		for (NhanSu nhanSu : danhSachNhanSu) {
			if (nhanSu.getMaSo().equals(maSo)) {
				if (isFind && nhanSu instanceof NhanVien) {
					NhanVien nv = (NhanVien) nhanSu;
					TruongPhong truongPhong = quanLiNhanVien.xoaNhanVien(nv);
					if (truongPhong != null) {
						// xóa nhân viên đó trong trưởng phòng
						quanLiTruongPhong.xoaNhanVien(truongPhong, nv);
					}
					isFind = false;
				}
				if (isFind && nhanSu instanceof GiamDoc) {
					// xóa trong list giám đốc
					quanLiGiamDoc.xoaGiamDoc((GiamDoc) nhanSu);
					isFind = false;
				}
				if (isFind && nhanSu instanceof TruongPhong) {
					// xóa trưởng phòng trong list TruongPhong, và nhân viên mà trưởng phòng đó quản lí
					TruongPhong tp = (TruongPhong) nhanSu;
					quanLiTruongPhong.xoaTruongPhong(tp);
					isFind = false;
				}
				// xóa khỏi list nhân sự
				danhSachNhanSu.remove(nhanSu);
				System.out.println("==> Xóa nhân sự");
				return true;
			}
		}
		System.err.println("==> Mã số của nhân sự không hợp lệ.Thử lại!!! ");
		return false;
	}

	public void xuatDanhSach() {
		System.out.println("==================>Danh Sách Toàn Bộ Nhân Sự<===================");
		for (NhanSu nhanSu : danhSachNhanSu) {
			nhanSu.xuatThongTin();
		}
		System.out.println("----------------------------------------------------------------");
	}

//	public void xuatDanhSachTruongPhong() {
//		quanLiTruongPhong.xuatTruongPhong();
//	}
	
	//xuất list chọn trưởng phòng
	public TruongPhong chonTruongPhong(Scanner sc) {
		System.out.println("==> Chọn Trưởng phòng cho nhân viên <==");
		TruongPhong tp = quanLiTruongPhong.chonTruongPhong(sc);
		return tp;
	}
	//xuất list chọn nhân viên
	public NhanVien chonNhanVien(Scanner sc) {
		System.out.println("==> Chọn nhân viên cho trưởng phòng <==");
		NhanVien nv = quanLiNhanVien.xuatChonNhanVien(sc);
		return nv;
	}

	public void phanBoNhanVienChoTp(NhanVien nv, TruongPhong tp) {
		if (nv.getTruongPhongQuanLy() != null) {
			// xóa trưởng phòng cũ khi gán trưởng phòng mới
			quanLiTruongPhong.xoaTruongPhongCu(nv);
		}
		// thêm trưởng phòng cho nhân viên
		nv.setTruongPhongQuanLy(tp);
		// thêm nhân viên vào danhSachNhanVien
		tp.themNhanVien(nv);
	}

	// Xuất lương
	public void xuatLuong() {
		for (NhanSu nhanSu : danhSachNhanSu) {
			nhanSu.xuatLuong();
		}
	}

	// NhanVien co luong cao nhat
	public void xuatLuongNhanVienMax() {
		quanLiNhanVien.xuatLuongCaoNhat();
	}

	// TruongPhong có cấp dưới nhiều nhất
	public void xuatTruongPhongNhieuNv() {
		quanLiTruongPhong.truongPhongNhieuNv();
	}

	public void sapXepThongTinTheoTen() {
		if(danhSachNhanSu.isEmpty()) {
			System.err.println("==> Không có nhân sự nào trong công ty!Hãy thêm nhân sự.");
			return;
		}
		Collections.sort(danhSachNhanSu, new Comparator<NhanSu>() {
			@Override
			public int compare(NhanSu o1, NhanSu o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (NhanSu nhanSu : danhSachNhanSu) {
			nhanSu.xuatThongTin();
		}
	}

	public void timGiamDocCoPhanHighest() {
		if(quanLiGiamDoc.getDanhSachGiamDoc().isEmpty()) {
			System.err.println("==> Không tồn tại giám đốc nào!Hãy them giám đốc");
			return;
		}
		quanLiGiamDoc.coPhanHighest();
	}

	// Tong Luong cong ty
	public double tongLuongCongTy() {
		double total = 0;
		for (NhanSu nhanSu : danhSachNhanSu) {
			total += nhanSu.tinhLuong();
		}
		return total;
	}

	public void tongThuNhapGiamDoc() {
		if(quanLiGiamDoc.getDanhSachGiamDoc().isEmpty()) {
			System.err.println("==> Không tồn tại giám đốc nào!Hãy them giám đốc");
			return;
		}
		quanLiGiamDoc.xuatThuNhap(tongLuongCongTy(), congTy.getDoanhThuThang());
		return;
	}
}
/*
 * Tổng thu nhập Lương tháng + số cổ phần * lợi nhuận công ty lợi nhuận công ty
 * = doanh thu thang - tổng lương toàn công ty 
 */
