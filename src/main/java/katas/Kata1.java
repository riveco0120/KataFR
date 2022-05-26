package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import model.Movie;
import util.DataUtil;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {

    public static List<Map<Integer,String>> execute() {
        List<Movie> movies = DataUtil.getMovies();
       List<Map<Integer,String>> nuevaList = movies.stream().map((item)->ImmutableMap.of(item.getId(),item.getTitle()))
               .collect(Collectors.toList());
        return nuevaList;
    }

}
