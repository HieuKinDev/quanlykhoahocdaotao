package entity;

import java.time.LocalDate;

import enums.CapDo;
import enums.HinhThucHoc;

public class KhoaHocLapTrinh extends KhoaHoc {
	private LocalDate ngayKhaiGiang;
	private CapDo capDo;
	
	public KhoaHocLapTrinh() {
		this("KH00", "Chua xac dinh", 1, HinhThucHoc.OFFLINE, 1.0, LocalDate.now().plusDays(1), CapDo.CO_BAN);
	}
	
	public KhoaHocLapTrinh(String maKhoaHoc, String tenKhoaHoc, int soTietHoc, HinhThucHoc hinhThucHoc,
			double hocPhiNiemYet, LocalDate ngayKhaiGiang, CapDo capDo) {
		super(maKhoaHoc, tenKhoaHoc, soTietHoc, hinhThucHoc, hocPhiNiemYet);
		setNgayKhaiGiang(ngayKhaiGiang);
		setCapDo(capDo);
	}

	public LocalDate getNgayKhaiGiang() {
		return ngayKhaiGiang;
	}

	public CapDo getCapDo() {
		return capDo;
	}

	public void setNgayKhaiGiang(LocalDate ngayKhaiGiang) {
		if (!ngayKhaiGiang.isAfter(LocalDate.now())) {
			throw new RuntimeException("Ngay khai giang phai sau ngay hien hanh");
		}
		this.ngayKhaiGiang = ngayKhaiGiang;
	}

	public void setCapDo(CapDo capDo) {
		if (capDo != CapDo.CO_BAN && capDo != CapDo.NANG_CAO && capDo != CapDo.CHUYEN_SAU) {
			throw new RuntimeException("Cap do khong hop le");
		}
		this.capDo = capDo;
	}

	@Override
	public double tinhHocPhiThucTe() {
		double phiPhong = 0.0, phiVanHanh = 0.0;
		if (capDo == CapDo.CHUYEN_SAU) {
			phiPhong = getHocPhiNiemYet() * 0.2;
		} else {
			phiPhong = getHocPhiNiemYet() * 0.1;
		}
		
		if (getHinhThucHoc() == HinhThucHoc.OFFLINE) {
			phiVanHanh = getHocPhiNiemYet() * 0.12;
		} else {
			phiVanHanh = getHocPhiNiemYet() * 0.05;
		}
		return getHocPhiNiemYet() + phiPhong + phiVanHanh;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%15s | %15s | ", ngayKhaiGiang, capDo);
	}
	
}
