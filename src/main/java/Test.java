//Esta clase contiene la solucion a lo pedido dentro de las katas

import com.google.common.collect.ImmutableList;
import katas.Kata1;
import katas.Kata2;
import katas.Kata3;

import java.util.List;
import java.util.Map;

public class Test {
    //Metodo para proyectar pelicular por id y titulo
    public void proyectar(List<Map<Integer,String>>list){
        list.stream().map(item->item.entrySet()).forEach(System.out::println);
    }

    //Metodo para listar por clasificacion

    public void mostrarPorClasificacion(List<ImmutableList<Integer>> list){
        list.stream().map(item->item).forEach(System.out::println);
    }
    public static void main(String[] args) {
        Test test = new Test();
        List<Map<Integer,String>> list = Kata1.execute();
      //  test.proyectar(list);
        List<ImmutableList<Integer>>list2 = Kata2.execute();
        //test.mostrarPorClasificacion(list2);
        List<ImmutableList<Integer>>lists3 = Kata3.execute();
        test.mostrarPorClasificacion(lists3);
    }
}
