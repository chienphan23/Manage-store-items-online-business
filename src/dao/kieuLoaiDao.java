package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.kieuLoaiBean;

public class kieuLoaiDao {
	public ArrayList<kieuLoaiBean> getdsL() throws Exception {
		ArrayList<kieuLoaiBean> dsl = new ArrayList<kieuLoaiBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from kieuLoai";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			long maKieuLoai = rs.getLong("maKieuLoai");
			String tenKieuLoai = rs.getString("tenKieuLoai");
			long maLoai = rs.getLong("maLoai");
			dsl.add(new kieuLoaiBean(maKieuLoai, tenKieuLoai, maLoai));
		}

		rs.close();
		kn.cn.close();
		return dsl;
	}

	public ArrayList<kieuLoaiBean> getdsLTheoMaLoai(long maLoaiInput) throws Exception {
		ArrayList<kieuLoaiBean> dsl = new ArrayList<kieuLoaiBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from kieuLoai where maLoai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maLoaiInput);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			long maKieuLoai = rs.getLong("maKieuLoai");
			String tenKieuLoai = rs.getString("tenKieuLoai");
			long maLoai = rs.getLong("maLoai");
			dsl.add(new kieuLoaiBean(maKieuLoai, tenKieuLoai, maLoai));
		}

		rs.close();
		kn.cn.close();
		return dsl;
	}
}