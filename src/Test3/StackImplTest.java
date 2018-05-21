package Test3;

import org.junit.*;

import static org.junit.Assert.*;


//Junit test  for StackImpl class
public class StackImplTest {
    private StackImpl<Long> testStack;

    @Before
    public void setUp(){
        testStack = new StackImpl<>();
    }

    @Test
    public void push() {
        Long i = 23L;
        assertEquals(i, testStack.push(i));

    }

    @Test
    public void pop() {
        Long i = 23L;
        testStack.push(i);
        assertEquals(i, testStack.pop());
    }

    @Test
    public void peek() {
        Long i = 23L;
        testStack.push(i);
        assertEquals(i, testStack.peek());
    }

    @Test
    public void empty() {
        Long i = 23L;
        testStack.push(i);
        assertFalse(testStack.empty());
    }

    @Test
    public void search(){
        Long i = 23L;
        testStack.push(i);
        assertNotEquals(-1, testStack.search(i));
    }
}