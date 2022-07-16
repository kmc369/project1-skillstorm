/*package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.models.movies;



	
@WebServlet(urlPatterns = "/findAll")

public class findAllServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("hello servlet");
			resp.setStatus(200);
		
			
	}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("Post Servlet ");
		
			//take in an json and conver it into an object 
			ObjectMapper mapper = new ObjectMapper();
			
			InputStream reqBody = req.getInputStream();
			movies movie = mapper.readValue(reqBody, movies.class); //take in the json request and turn it into an object
			
			
			resp.setContentType("application/json");
			//send an object as json 
			resp.getWriter().print(mapper.writeValueAsString(movie));
			
			System.out.println(movie);
		}
}
	
	
	*/

