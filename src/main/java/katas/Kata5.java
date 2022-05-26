package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Math.max;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        Double clasificacionMenor=0D;
        Double valor=movies.stream().map(item->item.getRating()).collect(Collectors.toList())
                .stream().reduce(clasificacionMenor,(a,b)->{
                    if(a>b){
                        return a;
                    }
                    return b;
                });
        return valor;
    }

}
