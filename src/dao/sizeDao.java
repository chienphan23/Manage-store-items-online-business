package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sizeBean;

public class sizeDao {
	public ArrayList<sizeBean> getDSSize() throws Exception {
		ArrayList<sizeBean> ds = new ArrayList<sizeBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from size";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maSize = rs.getLong("maSize");
			String tenSize = rs.getString("tenSize");
			ds.add(new sizeBean(maSize, tenSize));
		}
		cmd.close();
		kn.cn.close();
		return ds;

	}
}
