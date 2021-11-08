package src;

import src.data_structures.lists.LinkedList;

public class Main {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();

    for(int i=0; i<10; i++){
      list.addFirst(i);
      System.out.println(list.toString() + "| Tamanho: " + list.size());
    }
  }
}
