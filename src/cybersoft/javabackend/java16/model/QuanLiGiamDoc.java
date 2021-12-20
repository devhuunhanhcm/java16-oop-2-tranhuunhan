package cybersoft.javabackend.java16.model;

import java.util.ArrayList;
import java.util.List;

public class QuanLiGiamDoc {

	private List<GiamDoc> danhSachGiamDoc;

	public QuanLiGiamDoc() {
		this.danhSachGiamDoc = new ArrayList<GiamDoc>();
	}
	
	public boolean themGiamDoc(GiamDoc gd) {
		if(gd.getMaSo() == null || gd.getMaSo().equals(""))
			return false;
		return danhSachGiamDoc.add(gd);
	}
	public void xuatDanhSachGiamDoc() {
		for (GiamDoc giamDoc : danhSachGiamDoc) {
			giamDoc.xuatThongTin();
		}
	}
	public boolean xoaGiamDoc(GiamDoc gd) {
		System.out.println("==> Xóa giám đốc");
		return danhSachGiamDoc.remove(gd);
	}

	public void coPhanHighest() {
		float max = danhSachGiamDoc.get(0).getSoCoPhan();
		for (GiamDoc giamDoc : danhSachGiamDoc) {
			if(giamDoc.getSoCoPhan() > max) {
				max = giamDoc.getSoCoPhan();
			}
		}
		for (GiamDoc giamDoc : danhSachGiamDoc) {
			if(giamDoc.getSoCoPhan() == max) {
				giamDoc.xuatThongTin();
			}
		}
	}

	public void xuatThuNhap(double total,double doanhThuThang) {
		System.out.println("\t==> Thu nhập của tất cả giám đốc <==");
		for (GiamDoc giamDoc : danhSachGiamDoc) {
			giamDoc.xuatThuNhap(total, doanhThuThang);
		}
	}

	public List<GiamDoc> getDanhSachGiamDoc() {
		return danhSachGiamDoc;
	}

	public void setDanhSachGiamDoc(List<GiamDoc> danhSachGiamDoc) {
		this.danhSachGiamDoc = danhSachGiamDoc;
	}
	

}
