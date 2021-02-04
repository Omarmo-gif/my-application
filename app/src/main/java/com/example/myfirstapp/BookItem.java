package com.example.myfirstapp;

public class BookItem {
    private int frame;
    private String title;
    private String key_id;
    private String favStatus;
    private int bookimage;
    private String pagesandreviews;
    private String author;
    private float rate;
    private String description;

    public BookItem(int frame,String description, String title, String key_id, String favStatus, int bookimage, String pagesandreviews, String author,float rate) {
        this.description=description;
        this.frame = frame;
        this.rate=rate;
        this.title = title;
        this.key_id = key_id;
        this.favStatus = favStatus;
        this.bookimage = bookimage;
        this.pagesandreviews = pagesandreviews;
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public BookItem() {
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }

    public int getBookimage() {
        return bookimage;
    }

    public void setBookimage(int bookimage) {
        this.bookimage = bookimage;
    }

    public String getPagesandreviews() {
        return pagesandreviews;
    }

    public void setPagesandreviews(String pagesandreviews) {
        this.pagesandreviews = pagesandreviews;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


