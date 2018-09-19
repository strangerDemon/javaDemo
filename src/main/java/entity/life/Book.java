package entity.life;

import java.util.Date;

public class Book {
    private String name;
    private Person pubisher;
    private Date publishDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPubisher() {
        return pubisher;
    }

    public void setPubisher(Person pubisher) {
        this.pubisher = pubisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Book buyBook(){
        Book book=new Book();

        return book;
    }
}
