package com.clustering.project.dao;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Object getList(String sqlMapld, Object dataMap) {
		String query = "select * from CIP_MEMBER"
				+" where 1 = 1"
				+" order by NAME";
		return this.jdbcTemplate.queryForList(query);
	}
	
}
