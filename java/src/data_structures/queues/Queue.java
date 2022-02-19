package src.data_structures.queues;

import src.data_structures.lists.LinkedList;
import src.exceptions.EmptyListException;

public class Queue<T>{
  LinkedList<T> list;

  public Queue(){
    list = new LinkedList<>();
  }

  public T peek() throws EmptyListException{
    return list.peekFirst();
  } 

  public T poll() throws EmptyListException{
    return list.removeFirst();
  }

  public void insert(T value){
    list.addLast(value);
  }

  public boolean isEmpty(){
    return list.isEmpty();
  }
}
