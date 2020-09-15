package pl.adcom.teainewsapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.adcom.teainewsapp.model.NewsDb;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Repository
public class NewsDaoImpl implements NewsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addNews(long id, String author, String title, String description, String content, LocalDate publishDate, String url, String urlImage) {
        NewsDb newsDb = new NewsDb(author, title, description, content, publishDate, url, urlImage);
        String sql = "INSERT INTO news VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, newsDb.getId(), newsDb.getAuthor(), newsDb.getTitle(),
                            newsDb.getDescription(), newsDb.getContent(), newsDb.getPublishDate(),
                            newsDb.getUrl(), newsDb.getUrlImage());
    }

    @Override
    public List<NewsDb> getAllNews() {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "SELECT * FROM news";
        List<NewsDb> newsDbList = new ArrayList<>();
        List<Map<String, Object>> news = jdbcTemplate.queryForList(sql);
        news.stream().forEach(element -> newsDbList.add(new NewsDb(
                Long.parseLong(String.valueOf(element.get("id"))),
                String.valueOf(element.get("author")),
                String.valueOf(element.get("title")),
                String.valueOf(element.get("description")),
                String.valueOf(element.get("content")),
                LocalDate.parse(String.valueOf(element.get("publishDate"))),
                String.valueOf(element.get("url")),
                String.valueOf(element.get("urlImage"))
        )));
        return newsDbList;
    }

    @Override
    public NewsDb getNewsById(long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, i) ->
                new NewsDb(
                        rs.getLong("id"),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("content"),
                        Date.valueOf(rs.getString("publish_date")).toLocalDate(),
                        rs.getString("url"),
                        rs.getString("url_image")), id);
    }

    @Override
    public void modifyNews(NewsDb newsDb) {

    }

    @Override
    public NewsDb searchNewsById(long id) {
        return null;
    }

    @Override
    public void deleteNewsById(long id) {

    }
}
