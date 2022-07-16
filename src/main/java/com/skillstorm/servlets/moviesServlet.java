package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.Dao.movieDao;
import com.skillstorm.Dao.movie_Dao_imple;

import com.skillstorm.movies.movies;
import com.skillstorm.services.urlParserService;

@WebServlet(urlPatterns = "/movies/*")
public class moviesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	movieDao dao = new movie_Dao_imple();
	ObjectMapper mapper = new ObjectMapper();
	urlParserService url = new urlParserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<movies> movies = dao.findAll();
		//System.out.println(movies);
		
		if(movies != null) {
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(movies));
			
		}else {
			resp.setStatus(404);
		}
		
		
		}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		InputStream reqbody = req.getInputStream();
		movies newMovie = mapper.readValue(reqbody, movies.class); //this returns an artist 
		dao.save(newMovie);
		
		if(newMovie != null) {
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(newMovie));
		System.out.println(newMovie);
		}else {
			resp.setStatus(404);
		}
	}
		
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
		int id = url.extractId(req.getPathInfo());
		movies movie = dao.findById(id);
		
		if(movie != null) {
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(movie));
		}else {
			resp.setStatus(404);
			System.out.println("No artist found try anothe Id");
		}
		
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(movie));
		
	
	
		}catch(Exception e){
			List<movies> movies = dao.findAll();
			System.out.println(movies);
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(movies));
		}
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
