package com.example.macprosam.ytsmovies;

public class Movie {
    private int id;
    private String title;
    private String overview;
    private String desc;
    private String nomimage;
private Double valuerate;
private  String tag;
private  int year;

    public Double getValuerate() {
        return valuerate;
    }

    public void setValuerate(Double valuerate) {
        this.valuerate = valuerate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", desc='" + desc + '\'' +
                ", nomimage='" + nomimage + '\'' +
                ", valuerate=" + valuerate +
                ", tag='" + tag + '\'' +
                ", year=" + year +
                '}';
    }

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }



    public Movie() {
    }
}
