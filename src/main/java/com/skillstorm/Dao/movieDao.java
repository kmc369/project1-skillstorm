package com.skillstorm.Dao;

import java.util.List;

import com.skillstorm.movies.movies;

public interface movieDao {


//crud 
	
	//Reading 
	
	public List<movies>findAll();

	public movies findById (int id);
	
	public movies findByTitle (String title);
	
	
	//Creating 
	
	public movies save(movies movie);
	
	
	
	//update
	
	public void remakeYear(movies movie);
	
	
	
	//delete 
	
	public void delete(String title);
	
	public void delete(int id);
	
	
	//public void deleteMany(int [] ids);
	
}
