package Test3;

//interface of my realisation of TSStack
public interface TSStack<E> {

    // add element to stack
    E push(E item);

    // get element from top of the stack
    E pop();

    // look at the next element that gone be popped
    // may throw emptyStackException
    E peek();

    //check if stack is empty
    boolean empty();

    //search for specified object in stack
    int search(Object o);

}
