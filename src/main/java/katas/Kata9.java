package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<ImmutableMap> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<ImmutableMap> nuevaList = movieLists.stream().flatMap(item -> item.getVideos().stream()).
                map(item2 -> ImmutableMap.of("id", item2.getId(), "title", item2.getTitle(), "time", new Date(),
                        "url", item2.getBoxarts().stream().reduce((caratura1, caratura2) -> {
                            if (caratura1.getHeight() < caratura2.getHeight()) {
                                return caratura1;
                            }
                            return caratura2;
                        }).map(item3->item3.getUrl()).get()))
                .collect(Collectors.toList());

        return nuevaList;
    }

}
