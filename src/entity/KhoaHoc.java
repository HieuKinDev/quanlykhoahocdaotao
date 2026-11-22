package entity;

import java.text.DecimalFormat;

public abstract class KhoaHoc {
	protected String maKhoaHoc;
	protected String tenKhoaHoc;
	protected int soTietHoc;
	protected HinhThucHoc hinhThucHoc;
	protected double hocPhiNiemYet;
	
	public KhoaHoc() {
		this("KH00", "Chua xac dinh", 1, HinhThucHoc.OFFLINE, 1.0);
	}
	
	public KhoaHoc(String maKhoaHoc, String tenKhoaHoc, int soTietHoc, HinhThucHoc hinhThucHoc, double hocPhiNiemYet) {
		super();
		this.maKhoaHoc = maKhoaHoc;
		this.tenKhoaHoc = tenKhoaHoc;
		this.soTietHoc = soTietHoc;
		this.hinhThucHoc = hinhThucHoc;
		this.hocPhiNiemYet = hocPhiNiemYet;
	}

	public String getMaKhoaHoc() {
		return maKhoaHoc;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public int getSoTietHoc() {
		return soTietHoc;
	}

	public HinhThucHoc getHinhThucHoc() {
		return hinhThucHoc;
	}

	public double getHocPhiNiemYet() {
		return hocPhiNiemYet;
	}

	public void setMaKhoaHoc(String maKhoaHoc) {
		if (maKhoaHoc == null || maKhoaHoc.isBlank()) {
			throw new RuntimeException("Ma khoa hoc khong duoc rong!");
		}
		this.maKhoaHoc = maKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		if (tenKhoaHoc == null || tenKhoaHoc.isBlank()) {
			throw new RuntimeException("Ten khoa hoc khong duoc rong");
		}
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public void setSoTietHoc(int soTietHoc) {
		if (soTietHoc <= 0) {
			throw new RuntimeException("So tiet hoc phai lon hon 0");
		}
		this.soTietHoc = soTietHoc;
	}

	public void setHinhThucHoc(HinhThucHoc hinhThucHoc) {
		if (hinhThucHoc != HinhThucHoc.OFFLINE && hinhThucHoc != HinhThucHoc.OFFLINE) {
			throw new RuntimeException("Hinh thuc hoc chi bao gom ONLINE va OFFLINE");
		}
		this.hinhThucHoc = hinhThucHoc;
	}

	public void setHocPhiNiemYet(double hocPhiNiemYet) {
		if (hocPhiNiemYet <= 0) {
			throw new RuntimeException("Hoc phi niem yet phai lon ho 0");
		}
		this.hocPhiNiemYet = hocPhiNiemYet;
	}
	
	public abstract double tinhHocPhiThucTe();

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return String.format("| %15s | %15s | %15s | %15s | %15s | %15s | ", maKhoaHoc, tenKhoaHoc, soTietHoc, hinhThucHoc, df.format(hocPhiNiemYet), df.format(tinhHocPhiThucTe()));
	}
	
}
