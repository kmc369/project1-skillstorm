package com.skillstorm.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import com.skillstorm.conf.moviesDbCred;
import com.skillstorm.movies.movies;

public class movie_Dao_imple implements movieDao {

	/***
	 * @return the list of movies from the database, null if not 
	 * 
	 */
	@Override
	public List<movies> findAll() {
		String sql = "SELECT * FROM movie_List";
		
		try(Connection conn  = moviesDbCred.getInstance().getConnection()){
		
			
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		LinkedList<movies> movies = new LinkedList<>();

		while(rs.next()) { //next returns a boolean on whether the iterator is done
		
			movies movie = new movies(rs.getInt("movie_Id"), rs.getString("movie_Title"),rs.getString("lead_Actor"),rs.getString("movie_Genre"),rs.getInt("movie_Year"));
			
			movies.add(movie);
			
		}
			
			return movies;
		}catch (SQLException e) {
			e.printStackTrace();
		} 

		
		
		return null;
	}

	
	
	
	@Override
	public movies findById(int id) {
		
		
		try (Connection conn  = moviesDbCred.getInstance().getConnection()){
			
			String sql = "select * from movie_list where movie_Id =" + id;
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
		
			 return  new movies(rs.getInt("movie_Id"), rs.getString("movie_Title"),rs.getString("lead_Actor"),
					 	rs.getString("movie_Genre"),rs.getInt("movie_Year"));
		
		
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public movies findByTitle(String title) {
		
		try (Connection conn  = moviesDbCred.getInstance().getConnection()){
		
			String sql = "SELECT * FROM MOVIE_LIST WHERE MOVIE_TITLE = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
			return  new movies(rs.getInt("movie_Id"), rs.getString("movie_Title"),rs.getString("lead_Actor"),
				 	rs.getString("movie_Genre"),rs.getInt("movie_Year"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public movies save(movies movie) {
		
		String sql = "Insert into movie_List (movie_Title,lead_Actor,movie_Genre,movie_Year) Values (?,?,?,?)";
		
		try (Connection conn  = moviesDbCred.getInstance().getConnection()){
		
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getActor());
			ps.setString(3, movie.getGenre());
			ps.setInt(4, movie.getYear());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
			
				ResultSet keys = ps.getGeneratedKeys();
				
				if(keys.next()) {
					
					int key = keys.getInt(1);
					movie.setId(key);
					return movie;
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public void remakeYear(movies movie) {
		
		
	}



	@Override
	public void delete(int id) {
		String sql = "Delete from movie_list where movie_id =" +id;
		
		try(Connection conn  = moviesDbCred.getInstance().getConnection()){
			Statement stmt = conn.createStatement();
			int rowAffected = stmt.executeUpdate(sql);
			
			
			
			
			if(rowAffected !=0) {
				System.out.println("Movie successfully deleted from database");
			}
			else {
				System.out.println("That movie is not in the database");
			}
			
		
		
			
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void delete(String title) {
		
		String sql = "Delete from movie_list where movie_Title = ?";
		
		try(Connection conn  = moviesDbCred.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			int rowAffected =ps.executeUpdate(sql);
			
			
			
			if(rowAffected !=0) {
				System.out.println("Movie successfully deleted from database");
			}
			else {
				System.out.println("That movie is not in the database");
			}
			
		
		
			
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	









	




	

}
