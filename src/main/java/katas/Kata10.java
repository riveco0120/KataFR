package katas;

import com.google.common.collect.ImmutableMap;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {
    public static List<ImmutableMap> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();

        List<ImmutableMap> listSolucion = lists.stream().
                map(item->ImmutableMap.of("name",item.get("name"),"videos",
                                videos.stream().filter(item2->item2.get("listId").equals(item.get("id")))
                                .map(item3->ImmutableMap.of("id",item3.get("id"),"title",item3.get("title")))
                                .collect(Collectors.toList()))).collect(Collectors.toList());


        return listSolucion;
    }

    public static void main(String[] args) {
        System.out.println(Kata10.execute());
    }
}
