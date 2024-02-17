import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviesManagerTest {
    @Test
    public void moviesManagerEmptyAddMovieTest() {
        MoviesManager manager = new MoviesManager();

        String[] expected = {};
        String[] actual = manager.findAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moviesManagerFindOneMovieTest() {
        MoviesManager manager = new MoviesManager();

        manager.addNewMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moviesManagerFindAllMovieTest() {
        MoviesManager manager = new MoviesManager();

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Тролли.Мировой тур.");

        String[] expected = {"Бладшот", "Вперед", "Отель Белград", "Джентльмены", "Человек-невидимка", "Тролли.Мировой тур."};
        String[] actual = manager.findAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moviesManagerFindLastTestIfResultCountLowLimit() {
        MoviesManager manager = new MoviesManager(4);

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперед", "Бладшот"};
        String[] actual = manager.findLastMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moviesManagerFindLastTestLowToBorder() {
        MoviesManager manager = new MoviesManager(4);

        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Тролли.Мировой тур.");
        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперед", "Бладшот", "Тролли.Мировой тур."};
        String[] actual = manager.findLastMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moviesManagerFindLastTestToBorder() {
        MoviesManager manager = new MoviesManager(5);

        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Тролли.Мировой тур.");
        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперед", "Бладшот", "Тролли.Мировой тур.", "Человек-невидимка"};
        String[] actual = manager.findLastMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moviesManagerFindLastTestUpperBorder() {
        MoviesManager manager = new MoviesManager(6);

        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Тролли.Мировой тур.");
        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперед", "Бладшот", "Тролли.Мировой тур.", "Человек-невидимка", "Джентльмены"};
        String[] actual = manager.findLastMovies();
        Assertions.assertArrayEquals(expected, actual);
    }
}
