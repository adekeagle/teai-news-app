package pl.adcom.teainewsapp.dao;

import pl.adcom.teainewsapp.model.NewsDb;

import java.time.LocalDate;
import java.util.List;

public interface NewsDao {
    void addNews(long id, String author, String title, String description, String content, LocalDate publishDate, String url, String urlImage);
    List<NewsDb> getAllNews();
    NewsDb getNewsById(long id);
    void modifyNews(NewsDb newsDb);
    NewsDb searchNewsById(long id);
    void deleteNewsById(long id);
}
