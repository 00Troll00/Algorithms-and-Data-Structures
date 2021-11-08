package src;

import src.data_structures.lists.LinkedList;

public class Main {
  public static void main(String[] args) throws Exception{
    LinkedList<Integer> list = new LinkedList<>();

    for(int i=0; i<10; i++){
      list.addLast(i);
      System.out.println(list.toString() + "| Tamanho: " + list.size());
    }

    list.addBefore(5, 11);
    System.out.println(list.toString() + "| Tamanho: " + list.size());
  }
}
