package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> nuevaList =movieLists.stream().flatMap(item->item.getVideos().stream()).
                map(item2 -> ImmutableMap.of("id", item2.getId(), "title", item2.getTitle(),
                                "boxart",item2.getBoxarts().stream().reduce((caratura1,caratura2)->{
                                    if(caratura1.getHeight()<caratura2.getHeight()){
                                        return caratura1;
                                    }
                                    return caratura2;
                        })))
                .collect(Collectors.toList());

        return nuevaList;
    }

}
