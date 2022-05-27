package com.reetu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Tree;

@Repository
public class treerepo {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	
	//add tree
	public String add(Tree t, MultipartFile image) {
		try {
			 String query="insert into tdata values(?,?,?,?)";
			 int x=jdbctemplate.update(query, new Object[] {t.getTid(), t.getName(), t.getFruit(), image.getInputStream()});
			 if(x!=0) {
				 return "success";
			 }else {
				 return "failed";
			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
		}
	}
	
	//to get all 
	public List<Tree> getall(){
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tree t=new Tree();
				t.setTid(rs.getInt("tid"));
				t.setName(rs.getString("name"));
				t.setFruit(rs.getString("fruit"));
				return t;
			}
			
		}
		try {
			final String query="select * from tdata";
			List<Tree> t=jdbctemplate.query(query, new DataMapper());
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	// get tree by id
	public Tree gettreebyid(int tid) {
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tree t=new Tree();
				t.setTid(rs.getInt("tid"));
				t.setName(rs.getString("name"));
				t.setFruit(rs.getString("fruit"));
				return t;
			}
			
		}
		
		try {
			final String query="select * from tdata where tid=?";
			Tree t=(Tree)jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {tid});
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	//get like name tree
	public List<Tree> getlikename(String name){
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tree t=new Tree();
				t.setTid(rs.getInt("tid"));
				t.setName(rs.getString("name"));
				t.setFruit(rs.getString("fruit"));
				return t;
			}
			
		}
		try {
			final String query="select * from tdata where name like?";
			List<Tree> t=jdbctemplate.query(query, new DataMapper(), new Object[] {"%"+name+"%"});
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	// get image
	 public byte[] getimage(int tid) {
		 class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return rs.getBytes("image");
			}
			 
		 }
		 try {
			final String query="select image from tdata where tid=?";
			byte[] b=(byte[]) jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {tid});
			return b;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	 }
	 
	 //update tree
	 public String update(Tree t, MultipartFile image) {
		 try {
			 String query="update tdata set name=?,fruit=?,image=? where tid=?";
			 int x=jdbctemplate.update(query,new Object[] {t.getName(), t.getFruit(),image.getInputStream(), t.getTid()});
			 if(x!=0) {
				 return "success";
			 }else {
				 return "failed";
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
		}
	 }
	 
	 // delete by id
	 public String delete(int tid) {
		 try {
			 String query="delete from tdata where tid=?";
			 int x=jdbctemplate.update(query, new Object[] {tid});
			 if(x!=0) {
				 return "success";
			 }else {
				 return "failed";
			 }
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
		}
	 }
	 
	 //get all ids only
	 public List<Integer> getallids(){
		 class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getInt("tid");
			}
			 
		 }
		 try {
			final String query="select * from tdata";
			List<Integer> list=jdbctemplate.query(query, new DataMapper());
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	 }
}
