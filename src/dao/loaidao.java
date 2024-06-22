package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getdsL() throws Exception {
		ArrayList<loaibean> dsl = new ArrayList<loaibean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from loai";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			long maLoai = rs.getLong("maLoai");
			String tenLoai = rs.getString("tenLoai");
			dsl.add(new loaibean(maLoai, tenLoai));
		}

		rs.close();
		kn.cn.close();
		return dsl;
	}

	public loaibean getDSLTheoMaLoai(long maLoaiInput) throws Exception {
		loaibean dsl = new loaibean();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from loai where maLoai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maLoaiInput);
		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			long maLoai = rs.getLong("maLoai");
			String tenLoai = rs.getString("tenLoai");
			dsl = new loaibean(maLoai, tenLoai);
		}

		rs.close();
		kn.cn.close();
		return dsl;
	}
}
