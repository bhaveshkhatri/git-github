package org.cb.practice.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SupportJdbcDaoImpl extends JdbcDaoSupport {

	public int getCircleCount() {
		String sql = "select count(*) from circle";
		
		return getJdbcTemplate().queryForObject(sql, Integer.class);
				
	}
	
	
}
