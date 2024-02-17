public class MoviesManager {
    private String[] movies = new String[0];
    private int limit;

    public MoviesManager() {
        this.limit = 5;
    }

    public MoviesManager(int limit) {

        this.limit = limit;
    }


    public void addNewMovie(String newMovie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = newMovie;
        movies = tmp;
    }

    public String[] findAllMovies() {
        return movies;
    }

    public String[] findLastMovies() {
        int resultCount;
        if (movies.length < limit) {
            resultCount = movies.length;
        } else {
            resultCount = limit;
        }
        String[] tmp = new String[resultCount];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;
    }
}
