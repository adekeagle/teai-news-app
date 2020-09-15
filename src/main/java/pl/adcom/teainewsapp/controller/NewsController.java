package pl.adcom.teainewsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.adcom.teainewsapp.service.NewsService;

@Controller
@RequestMapping("/api/news")
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    public String getAllNews(Model model){
        model.addAttribute("newsList", newsService.getAllNews());
        return "news";
    }
}
