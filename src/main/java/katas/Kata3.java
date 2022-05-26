package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<ImmutableList<Integer>> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<ImmutableList<Integer>>nuevaList=movieLists.stream().flatMap(item->item.getVideos().stream()
                .map(movie ->ImmutableList.of(movie.getId()))).collect(Collectors.toList());

        return nuevaList;
    }
}
