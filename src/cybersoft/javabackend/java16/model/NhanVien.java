package cybersoft.javabackend.java16.model;


public class NhanVien extends NhanSu {
	private TruongPhong truongPhongQuanLy;
	
	public NhanVien() {
		truongPhongQuanLy = new TruongPhong();
	}
	@Override
	public void xuatThongTin() {
		System.out.println("\n\t==> Nhân Viên <==");
		super.xuatThongTin();
		if(truongPhongQuanLy == null || truongPhongQuanLy.getMaSo().equals("")) {
			System.out.println(new StringBuilder()
					.append("\tChưa có trưởng phòng quản lí").toString());
			return;
		}
		System.out.println(new StringBuilder()
				.append("\tTên TP quản lí: ")
				.append(truongPhongQuanLy.getName())
				.append("\n\tMã số TP quản lí: ")
				.append(truongPhongQuanLy.getMaSo())
				.toString());
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
	
	// Chọn nhân viên để thêm 
	public void chonNhanVien(int i) {
		String thongTin = new StringBuilder()
						.append("\n[").append(i).append("] NV [ ")
						.append("Tên: ").append(this.name)
						.append(", Mã Số: ").append(this.maSo)
						.append(" ]")
						.toString();
		System.out.print(thongTin);
	}
	public TruongPhong getTruongPhongQuanLy() {
		return truongPhongQuanLy;
	}
	public void setTruongPhongQuanLy(TruongPhong truongPhongQuanLy) {
		this.truongPhongQuanLy = truongPhongQuanLy;
	}
	
}
