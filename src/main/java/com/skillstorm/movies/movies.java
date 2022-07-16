package com.skillstorm.movies;

public class movies {

	private int id;
	private String title;
	private String Actor;
	private String Genre;
	private int Year;
	
	
	public movies() {
		
	}


	// this will auto increment the
	public movies(String title, String actor, String genre, int year) {
		super();
		this.title = title;
		Actor = actor;
		Genre = genre;
		Year = year;
	}



	public movies(int id, String title, String actor, String genre, int year) {
		super();
		this.id = id;
		this.title = title;
		Actor = actor;
		Genre = genre;
		Year = year;
	}





	@Override
	public String toString() {
		return "movies [id=" + id + ", title=" + title + ", Actor=" + Actor + ", Genre=" + Genre + ", Year=" + Year
				+ "]";
	}








	public int getId() {
		return id;
	}








	public void setId(int id) {
		this.id = id;
	}








	public String getTitle() {
		return title;
	}








	public void setTitle(String title) {
		this.title = title;
	}








	public String getActor() {
		return Actor;
	}








	public void setActor(String actor) {
		Actor = actor;
	}








	public String getGenre() {
		return Genre;
	}








	public void setGenre(String genre) {
		Genre = genre;
	}








	public int getYear() {
		return Year;
	}








	public void setYear(int year) {
		Year = year;
	}








	
	
	
	
}
