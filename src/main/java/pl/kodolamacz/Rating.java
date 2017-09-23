package pl.kodolamacz;

public class Rating {

    private final int userId;
    private final int movieId;
    private final double rate;

    public Rating(int userId, int movieId, double rate) {
        this.userId = userId;
        this.movieId = movieId;
        this.rate = rate;
    }

    public int getUserId() {
        return userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public double getRate() {
        return rate;
    }
}
