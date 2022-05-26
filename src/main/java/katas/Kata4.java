package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> nuevaList =movieLists.stream().flatMap(item->item.getVideos().stream()).
               map(item2 -> ImmutableMap.of("id", item2.getId(), "title", item2.getTitle(), "boxart", new BoxArt(150, 200, item2.getUri())))
               .collect(Collectors.toList());
        return nuevaList;
    }
}
