

import java.util.LinkedList;
import java.util.List;

import com.skillstorm.Dao.movieDao;
import com.skillstorm.Dao.movie_Dao_imple;
import com.skillstorm.movies.movies;

public class Driver {

	

	public static void main(String[] args) {
		
		movieDao dao = new movie_Dao_imple();  //movie_Dao_imple = new movie_Dao_imple
		movies movie = new movies("Hunger games","katness everdeen","action",2020,21);
		dao.remakeYear(movie);
		
	
		//System.out.println(r);
	}
}
