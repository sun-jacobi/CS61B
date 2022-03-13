package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /* Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     * && is the "and" operation. */
    public void addLastTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addLast("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
    }

    @Test
    /* Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     * && is the "and" operation. */
    public void addFirstTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addFirst("middle");
        assertEquals(2, lld1.size());

        lld1.addFirst("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }


    @Test
    /* Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
        lld1.addLast(20);
        lld1.addLast(30);
		// should not be empty
		assertFalse("lld1 should contain 2 item", lld1.isEmpty());

		lld1.removeFirst();

        lld1.removeLast();
        assertEquals("lld1 should contain 2 item",1,lld1.size());
        lld1.removeFirst();
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {



        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();


        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
        assertNull("should return null",lld1.removeFirst());

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
        assertEquals("String list should contain no item", "string",s);
        assertEquals("Double list should contain no item", 3.14159,d, 0.00000d);
        assertTrue("Boolean list should contain no item",b);
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        assertNull("Should return null when removeFirst is called on an empty Deque,",lld1.removeFirst());
        assertNull("Should return null when removeLast is called on an empty Deque,",lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }


    @Test
    /* test the get method */
    public void getTest(){
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        for(int i = 0; i < 10; i++){
            lld.addLast(i);
        }
        for(int i = 0; i < 10 ; i++){
            int gt = lld.get(i);
            assertEquals(i,gt);
        }
    }

    @Test
    /* test the getRecursive method */
    public void getRecursiveTest(){
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        for(int i = 0; i < 10; i++){
            lld.addLast(i);
        }
        for(int i = 0; i < 10 ; i++){
            int gt = lld.getRecursive(i);
            assertEquals(i,gt);
        }
    }

    @Test
    /* test the iterator*/
    public void iteratorTest(){
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        for(int i = 0; i < 10; i++){
            lld.addLast(i);
        }
        int num = 0;
        for (int x : lld){
            assertEquals(num,x);
            num++;
        }
    }

    @Test
    /* test the equal method */
    public void equalTest(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        for(int i = 0; i < 10; i++){
            lld1.addLast(i);
            lld2.addLast(i);
        }
        assertTrue(lld1.equals(lld2));
    }
    @Test
    /* test the equal method */
    public void polyEqualTest(){
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        for(int i = 0; i < 10; i++){
            lld1.addLast("Shit");
            lld2.addLast(i);
        }
        assertFalse(lld1.equals(lld2));
    }



}
