package entity;

import enums.HinhThucHoc;
import enums.NgonNguDaoTao;

public class KhoaHocNgoaiNgu extends KhoaHoc {
	private NgonNguDaoTao ngonNguDaoTao;
	
	public KhoaHocNgoaiNgu() {
		this("KH00", "Chua xac dinh", 1, HinhThucHoc.OFFLINE, 1.0, NgonNguDaoTao.ANH);
	}

	public KhoaHocNgoaiNgu(String maKhoaHoc, String tenKhoaHoc, int soTietHoc, HinhThucHoc hinhThucHoc,
			double hocPhiNiemYet, NgonNguDaoTao ngonNguDaoTao) {
		super(maKhoaHoc, tenKhoaHoc, soTietHoc, hinhThucHoc, hocPhiNiemYet);
		setNgonNguDaoTao(ngonNguDaoTao);
	}

	public NgonNguDaoTao getNgonNguDaoTao() {
		return ngonNguDaoTao;
	}

	public void setNgonNguDaoTao(NgonNguDaoTao ngonNguDaoTao) {
		if (ngonNguDaoTao != NgonNguDaoTao.ANH && ngonNguDaoTao != NgonNguDaoTao.HAN && ngonNguDaoTao != NgonNguDaoTao.NHAT) {
			throw new RuntimeException("Ngon ngu dao tao khong hop le");
		}
		this.ngonNguDaoTao = ngonNguDaoTao;
	}

	@Override
	public double tinhHocPhiThucTe() {
		double phiTaiLieuBanQuyen = 0.0;
		if (ngonNguDaoTao == NgonNguDaoTao.NHAT) {
			phiTaiLieuBanQuyen = getHocPhiNiemYet() * 0.15;
		} else {
			phiTaiLieuBanQuyen = getHocPhiNiemYet() * 0.1;
		}
		
		return getHocPhiNiemYet() + phiTaiLieuBanQuyen;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%15s | ", ngonNguDaoTao);
	}
	
}
