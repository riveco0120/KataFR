//Esta clase contiene la solucion a lo pedido dentro de las katas

import katas.Kata1;

import java.util.List;
import java.util.Map;

public class Test {
    //Metodo para proyectar pelicular por id y titulo
    public void proyectar(List<Map<Integer,String>>list){
        list.stream().map(item->item.entrySet()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Test test = new Test();
        List<Map<Integer,String>> list = Kata1.execute();
        test.proyectar(list);
    }
}
