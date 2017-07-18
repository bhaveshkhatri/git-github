package org.cb.practice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.cb.practice.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {


	DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;	 
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private SimpleJdbcTemplate simpleJdbcTemplate; // only for latest versions of spring
								// to use both JdbcTemplate and NamedParameterJdbcTemplate
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}	
	
	public Circle getCircle(int circleId) {
		
		Connection con = null;
		
		
		try {
			
		con = dataSource.getConnection();
		
		PreparedStatement pst = con.prepareStatement("select *from circle where id=?");
		pst.setInt(1, circleId);
		
		Circle circle = null;
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			circle = new Circle(circleId, rs.getString("name"));
		}
		
		rs.close();
		pst.close();
		return circle;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public int getCircleCount() {
		String sql = "select count(*) from circle";
		
		return jdbcTemplate.queryForObject(sql, Integer.class);
				
	}
	
	public String getCircleName(int circleId) {
		String sql = "select name from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
	}

	public Circle getCircleForId(int circleId) {
		String sql = "select *from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCircle() {
		String sql = "select *from circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	/*public void insertCircle(Circle circle) {
		
		String sql = "insert into circle(id, name) values(?, ?)";
		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()}); 
	}*/
	
	
	public void insertCircle(Circle circle) {
		
		String sql = "insert into circle(id, name) values(:id, :name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
													.addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
	
	public void createTriangleTable() {
		
		String sql = "create table triangle(id integer, name varchar(50))";
		jdbcTemplate.execute(sql);
	}
	
	public static final class CircleMapper implements RowMapper<Circle> {
 
		@Override
		public Circle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("id"));
			circle.setName(resultSet.getString("name"));
			return circle;
		}
		
		
	}
	
}
