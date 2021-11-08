package src.data_structures.lists;

import src.exceptions.ElementNotFoundException;
import src.exceptions.EmptyListException;

public class LinkedList<T> {
  private Element<T> head;
  private Element<T> tail;
  private int size;

  public LinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  private class Element<T>{
    T data;
    Element<T> next;

    Element(T data, Element<T> next){
      this.data = data;
      this.next = next;
    }

    public T getData(){
      return this.data;
    }

    public void setData(T data){
      this.data = data;
    }

    public Element<T> getNext(){
      return this.next;
    }

    public void setNext(Element<T> next){
      this.next = next;
    }
  }//end class Node

  public boolean isEmpty(){
    return head == null;
  }

  public void clear(){
    this.head = null;
    this.tail = null;
  }

  public int size(){
    return this.size;
  }

  public void addFirst(T data){
    Element<T> temp = new Element<>(data, head);
    if(head == null)
      tail = temp;
    head = temp;
    size++;
  }//end addFirst

  public void addLast(T data){
    Element<T> temp = new Element<>(data, null);
    if(head == null){
      head = temp;
      tail = temp;
    }
    else{
      tail.setNext(temp);
      tail = temp;
    }
    size++;
  }//end addLast

  public void addAfter(T searchData, T newData) throws EmptyListException, ElementNotFoundException{
    if(head == null)
      throw new EmptyListException();

    if(searchData.hashCode() == head.hashCode())
      addFirst(newData);
    if(searchData.hashCode() == tail.hashCode() && head != tail)
      addLast(newData);
    else{
      Element<T> pointer = head;
      //searching for the Element
      while(pointer != null && pointer.getData().hashCode() != searchData.hashCode()){
        pointer.getNext();
      }
      if(pointer == null)
        throw new ElementNotFoundException();

      Element<T> newElement = new Element<>(newData, pointer.getNext());
      pointer.setNext(newElement);
      size++;
    }
  }//end addAfter

  public void addBefore(T searchData, T newData) throws EmptyListException, ElementNotFoundException{
    if(head == null)
      throw new EmptyListException();

    if(searchData.hashCode() == head.hashCode())
      addFirst(newData);
    if(searchData.hashCode() == tail.hashCode() && head != tail)
      addLast(newData);
    else{
      Element<T> pointer = head;
      Element<T> previousPointer = null;
      while(pointer != null && pointer.getData().hashCode() != searchData.hashCode()){
        previousPointer = pointer;
        pointer = pointer.getNext();
      }
      if(pointer == null)
        throw new ElementNotFoundException();
      previousPointer.setNext(new Element<>(newData, pointer));
      size++;
    }
  }//end addBefore

  public T removeFirst() throws EmptyListException{
    T data;
    if(head == null)
      throw new EmptyListException();
    if(head == tail){
      data = head.getData();
      clear();
      size--;
      return data;
    }
    data = head.getData();
    head = head.getNext();
    size--;

    return data;
  }//end removeFirst

  public T removeLast() throws EmptyListException{
    T data;
    if(head == null)
      throw new EmptyListException();
    if(head == tail){
      data = tail.getData();
      clear();
      size--;
      return data;
    }

    Element<T> pointer = head.getNext();
    Element<T> previousPointer = head;

    while(pointer != tail){
      previousPointer = pointer;
      pointer = pointer.getNext();
    }

    data = tail.getData();
    tail = previousPointer;
    tail.setNext(null);
    size--;
    
    return data;
  }//end removeLast

  public T remove(T searchData) throws EmptyListException, ElementNotFoundException{
    T data;
    if(head == null)
      throw new EmptyListException();
    if(searchData.hashCode() == head.hashCode())
      removeFirst();
    if(searchData.hashCode() == tail.hashCode() && head != tail)
      removeLast();

    Element<T> pointer = head;
    Element<T> previousPointer = null;
    while(pointer != null && pointer.getData().hashCode() != searchData.hashCode()){
      previousPointer = pointer;
      pointer = pointer.getNext();
    }
    if(pointer == null)
      throw new ElementNotFoundException();
    previousPointer.setNext(pointer.getNext());
    data = pointer.getData();
    pointer = null;

    return data;
  }//end remove

  public T peekFirst() throws EmptyListException{
    if(head == null)
      throw new EmptyListException();
    return head.getData();
  }//end peekFirst

  public T peekLast()throws EmptyListException{
    if(head == null)
      throw new EmptyListException();
    return tail.getData();
  }//end peekLast

  public boolean search(T data){
    Element<T> pointer = head;
    while(pointer != null && pointer.getData().hashCode() != data.hashCode())
      pointer = pointer.getNext();
    return pointer != null;
  }//end searck

  @Override
  public String toString(){
    String list = "";
    for(Element<T> pointer = head; pointer != null; pointer=pointer.getNext()){
      list += pointer.getData().toString() + " ";
    }
    return list;
  }//end toString
}//end class LinkedList