package items;

public class Movie extends Item {
    private double timeInMinutes;
    private MovieType movieType;
    private String scenarist;

    public Movie(String title, int amount, int availableAmount, String author, String description, double timeInMunutes, String scenarist, MovieType movieType) {
        super(title, amount, availableAmount, author, description);
        this.timeInMinutes = timeInMunutes;
        this.movieType = movieType;
        this.scenarist = scenarist;
    }

    public double getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(double timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getScenarist() {
        return scenarist;
    }

    public void setScenarist(String scenarist) {
        this.scenarist = scenarist;
    }
}
