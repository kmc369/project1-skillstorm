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


//dont touch this 
@WebServlet(urlPatterns = "/findAll")

public class findAllServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;
		

		movieDao dao = new movie_Dao_imple();
		ObjectMapper mapper = new ObjectMapper();
		urlParserService url = new urlParserService();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			List<movies> movie = dao.findAll();
			System.out.println(movie);
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(movie));
			
		
			
	}
		

}
	
	


