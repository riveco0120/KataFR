package katas;

import model.Bookmark;
import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {

        List<Movie> movies = DataUtil.getMovies();

        List<List<BoxArt>> lists = movies.stream().map(movie -> movie.getBoxarts()).collect(Collectors.toList());

        List<BoxArt> boxArts = lists.stream().flatMap(boxArt -> boxArt.stream()).collect(Collectors.toList());
        String valor = boxArts.stream().reduce((url1, url2) -> {
            if (url1.getWidth() > url2.getWidth()) {
                return url1;
            }
            return url2;
        }).get().getUrl();

        return valor;
    }

}
