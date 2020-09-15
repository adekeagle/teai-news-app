package pl.adcom.teainewsapp.model;

import java.time.LocalDate;

public class NewsDb {

    private long id;
    private String author;
    private String title;
    private String description;
    private String content;
    private LocalDate publishDate;
    private String url;
    private String urlImage;

    public NewsDb(long id, String author, String title, String description, String content, LocalDate publishDate, String url, String urlImage) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.content = content;
        this.publishDate = publishDate;
        this.url = url;
        this.urlImage = urlImage;
    }

    public NewsDb(String author, String title, String description, String content, LocalDate publishDate, String url, String urlImage) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.content = content;
        this.publishDate = publishDate;
        this.url = url;
        this.urlImage = urlImage;
    }

    public NewsDb(long id, String url) {
        this.id = id;
        this.url = url;
    }

    public NewsDb() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "NewsDb{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
