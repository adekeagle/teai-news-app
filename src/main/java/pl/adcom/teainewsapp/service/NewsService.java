package pl.adcom.teainewsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.adcom.teainewsapp.dao.NewsDao;
import pl.adcom.teainewsapp.model.Article;
import pl.adcom.teainewsapp.model.NewsDb;

import java.time.LocalDate;
import java.util.List;

@Service
public class NewsService {

    private static final String APIKEY = "3e8b2a916e134515897713f5b006a475";
    private static final String API = "http://newsapi.org/v2/everything?q=bitcoin&from=2020-08-15&sortBy=publishedAt&apiKey=" + APIKEY;

    private NewsDao newsDao;

    @Autowired
    public NewsService(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public Article articleNews(){
        RestTemplate restTemplate = new RestTemplate();
        Article article = restTemplate.getForObject(API, Article.class);

        return article;
    }

    public void addNewArticle(){
        int amount = 10;

        for(int i = 0; i < amount; i++){
            System.out.println(i);
            newsDao.addNews(i,
                    articleNews().getAuthor(),
                    articleNews().getTitle(),
                    articleNews().getDescription(),
                    articleNews().getContent(),
                    LocalDate.parse(articleNews().getPublishedAt()),
                    articleNews().getUrl(),
                    articleNews().getUrlToImage());
        }
    }

    public List<NewsDb> getAllNews(){
        return newsDao.getAllNews();
    }

    public NewsDb getNewsById(long id){
        return newsDao.getNewsById(id);
    }

    public void modifyNews(NewsDb newsDb){
        newsDao.modifyNews(newsDb);
    }

    public NewsDb searchNewsById(long id){
        return newsDao.searchNewsById(id);
    }

    public void delNewsById(long id){
        newsDao.deleteNewsById(id);
    }
}
