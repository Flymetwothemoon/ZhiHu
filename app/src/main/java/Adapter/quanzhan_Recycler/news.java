package Adapter.quanzhan_Recycler;

import java.util.List;

public class news {
    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String news;

    public String getAuthor() {
        return author;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String>images;
    public void setAuthor(String author) {
        this.author = author;
    }

    public String author;
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String url;

}
