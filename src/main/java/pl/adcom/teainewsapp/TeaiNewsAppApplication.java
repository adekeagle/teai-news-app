package pl.adcom.teainewsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.adcom.teainewsapp.dao.NewsDao;

import java.time.LocalDate;

@SpringBootApplication
public class TeaiNewsAppApplication {

	@Autowired
	private NewsDao newsDao;

	public static void main(String[] args) {
		SpringApplication.run(TeaiNewsAppApplication.class, args);
	}

	@Bean
	public void NewsTest(){
		this.newsDao = newsDao;

		newsDao.addNews(1L, "test", "test", "asdasd", "asdasd", LocalDate.now(), "asdasd", "asdas");
		newsDao.addNews(2L, "test1", "test1", "asdasd1", "asdasd1", LocalDate.now(), "asdasd1", "asdas1");

		newsDao.getAllNews().forEach(System.out::println);
	}
}