package cn.et.model;

import java.util.List;
import java.util.Map;

import cn.et.DbUtils;

public class MyNews {
	/**
	 * ��ѯ
	 */
	public List<Map> queryNews() {
		String sql="select * from mynews";
		return DbUtils.query(sql);
	}
}
