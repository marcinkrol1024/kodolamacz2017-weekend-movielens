package pl.kodolamacz;

public class Movie {

    private int id;
    private String title;
    private String genres;

    public Movie(int id, String title, String genres) {
        this.id = id;
        this.title = title;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenres() {
        return genres;
    }

    public int getYear(){
        return 0;
    }
}
