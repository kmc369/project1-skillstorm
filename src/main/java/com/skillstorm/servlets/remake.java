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


@WebServlet(urlPatterns = "/remake")
public class remake extends HttpServlet {
	
	movieDao dao = new movie_Dao_imple();
	ObjectMapper mapper = new ObjectMapper();
	urlParserService url = new urlParserService();
	private static final long serialVersionUID = 1L;
	
protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
		InputStream reqbody = req.getInputStream();
		movies updatedMovie = mapper.readValue(reqbody,movies.class);
		
		dao.remakeYear(updatedMovie);
		
	
		
		}catch(Exception e) {
			
			List<movies> movies = dao.findAll();
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(movies));
			
			
		}
	}	

}
