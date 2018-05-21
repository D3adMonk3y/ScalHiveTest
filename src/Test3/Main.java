package Test3;

public class Main {
    public static void main(String[] args) {
        StackImpl<String> stringStack = new StackImpl<>();
        stringStack.push("sfsdsd");
        stringStack.push("sdfsdfssdf");
        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());

    }
}
