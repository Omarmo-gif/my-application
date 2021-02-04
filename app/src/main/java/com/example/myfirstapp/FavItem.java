package com.example.myfirstapp;

public class FavItem {
    private int frame;
    private String title;
    private String key_id;
    private int bookimage;
    private String pagesandreviews;
    private String author;
    private float rate;

    public FavItem(int frame, String title, String key_id, int bookimage, String pagesandreviews, String author,float rate) {
        this.frame = frame;
        this.rate=rate;
        this.title = title;
        this.key_id = key_id;
        this.bookimage = bookimage;
        this.pagesandreviews = pagesandreviews;
        this.author = author;
    }

    public FavItem() {
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
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


