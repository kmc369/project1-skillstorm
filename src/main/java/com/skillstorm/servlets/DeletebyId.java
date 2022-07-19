package com.skillstorm.servlets;

import java.io.IOException;
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

@WebServlet(urlPatterns = "/deleteById/*")
public class DeletebyId  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	movieDao dao = new movie_Dao_imple();
	ObjectMapper mapper = new ObjectMapper();
	urlParserService url = new urlParserService();
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		try {
			
			int id = url.extractId(req.getPathInfo());
			dao.delete(id);

			

		
		}catch (Exception e) {
			
			List<movies> movie = dao.findAll();
			
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(movie));
			
		}
		

	}

}
