import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    public ToDoList toDoList;
    public Item item1, item11, item2;

    @BeforeEach
    public void reset(){
        toDoList = new ToDoList();
        item1 = new Item("item1", "", LocalDateTime.now());
        item11 = new Item("item1", "", LocalDateTime.now());
        item2 = new Item("item2", "", LocalDateTime.now());
    }

    @Test
    public void add_item_should_succeed(){
        assertTrue( toDoList.addItem(item1));
    }

    @Test
    public void add_item_should_failed_added_before_30_min(){
        Item item_25_min_ago = new Item("item_25", "", LocalDateTime.now().minusMinutes(29));
        Item item = new Item("item", "", LocalDateTime.now());
        toDoList.addItem(item_25_min_ago);
        assertFalse(toDoList.addItem(item));
    }

    @Test
    public void add_item_should_succeed_added_after_more_than_30_min(){
        Item item_31_min_ago = new Item("item_25", "", LocalDateTime.now().minusMinutes(31));
        Item item = new Item("item", "", LocalDateTime.now());
        toDoList.addItem(item_31_min_ago);
        assertTrue(toDoList.addItem(item));
    }

    @Test
    public void add_item_should_succeed_added_after_30_min(){
        Item item_31_min_ago = new Item("item_25", "", LocalDateTime.now().minusMinutes(30));
        Item item = new Item("item", "", LocalDateTime.now());
        toDoList.addItem(item_31_min_ago);
        assertTrue(toDoList.addItem(item));
    }

    @Test
    public void add_2_item_with_same_name_should_failed(){
        Item item = new Item("item", "", LocalDateTime.now().minusMinutes(31));
        Item item2 = new Item("item", "", LocalDateTime.now());
        toDoList.addItem(item);
        assertFalse( toDoList.addItem(item2));
    }

    @Test
    public void add_11_item_should_failed(){
        for (int i = 9; i >= 0; i--) {
            toDoList.addItem(new Item("test"+i, "", LocalDateTime.now().minusMinutes(30L *i)));
        }
        assertFalse( toDoList.addItem(new Item("test11", "", LocalDateTime.now())) );
    }

    @Test
    public void add_8_item_should_ask_to_send_an_email(){
        for (int i = 7; i >= 0; i--) {
            assertTrue( toDoList.addItem(new Item("test"+i, "", LocalDateTime.now().minusMinutes(30L *i))) );
        }
        assertTrue( toDoList.shouldSendEmail());
    }

}
