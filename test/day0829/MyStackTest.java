package day0829;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.my.classcodes.day0829.MyStack;

public class MyStackTest {
	private MyStack<String> stack;

	@Before
	public void init() {
		stack = new MyStack<>();
	}

	@Test
	public void test_push() {
		assertTrue(stack.push("a"));
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		stack.push("f");
		stack.push("g");
		stack.push("h");
		stack.push("i");
		stack.push("j");

		assertEquals(10, stack.getSize());

		assertFalse(stack.push("extraElement"));
	}

	@Test
	public void test_pop() {
		assertNull(stack.pop());
		stack.push("a");
		stack.push("b");
		stack.push("c");

		assertEquals("c", stack.pop());
		assertEquals(2, stack.getSize());
	}

	@Test
	public void test_top_element() {
		assertNull(stack.topElement());
		stack.push("a");
		stack.push("b");
		assertEquals("b", stack.topElement());
		assertEquals(2, stack.getSize());
	}

	@Test
	public void test_empty() {
		assertTrue(stack.isEmpty());
		stack.push("a");
		assertFalse(stack.isEmpty());
	}

	@Test
	public void test_full() {
		assertFalse(stack.isFull());
		stack.push("a");
		assertFalse(stack.isFull());

		for (int i = 0; i < 10; i++)
			stack.push("a");
		assertTrue(stack.isFull());
	}

	@Test
	public void test_print() {
		stack.printElements();
		stack.push("bottom");
		stack.push("middle");
		stack.push("top");
		stack.printElements();
	}

	@After
	public void destroy() {
		stack = null;
	}
}
