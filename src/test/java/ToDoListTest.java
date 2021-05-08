import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ToDoListTest {
    public ToDoList toDoList;
    public Item item1, item11, item2;

    @Before
    public void reset(){
        toDoList = new ToDoList();
        item1 = new Item("item1", "", LocalDateTime.now());
        item11 = new Item("item1", "", LocalDateTime.now());
        item2 = new Item("item2", "", LocalDateTime.now());
    }

    @Test
    public void add_item_should_succeed(){
        Assert.assertTrue( toDoList.addItem(item1));
    }

    @Test
    public void add_item_should_failed_added_before_30_min(){
        Item item_25_min_ago = new Item("item_25", "", LocalDateTime.now().minusMinutes(29));
        Item item = new Item("item", "", LocalDateTime.now());
        toDoList.addItem(item_25_min_ago);
        Assert.assertFalse(toDoList.addItem(item));
    }

    @Test
    public void add_item_should_succeed_added_after_more_than_30_min(){
        Item item_31_min_ago = new Item("item_25", "", LocalDateTime.now().minusMinutes(31));
        Item item = new Item("item", "", LocalDateTime.now());
        toDoList.addItem(item_31_min_ago);
        Assert.assertTrue(toDoList.addItem(item));
    }

    @Test
    public void add_item_should_succeed_added_after_30_min(){
        Item item_31_min_ago = new Item("item_25", "", LocalDateTime.now().minusMinutes(30));
        Item item = new Item("item", "", LocalDateTime.now());
        toDoList.addItem(item_31_min_ago);
        Assert.assertTrue(toDoList.addItem(item));
    }

    @Test
    public void add_2_item_with_same_name_should_failed(){
        Item item = new Item("item", "", LocalDateTime.now().minusMinutes(31));
        Item item2 = new Item("item", "", LocalDateTime.now());
        toDoList.addItem(item);
        Assert.assertFalse( toDoList.addItem(item2));
    }

    @Test
    public void add_11_item_should_failed(){
        for (int i = 9; i >= 0; i--) {
            toDoList.addItem(new Item("test"+i, "", LocalDateTime.now().minusMinutes(30L *i)));
        }
        Assert.assertFalse( toDoList.addItem(new Item("test11", "", LocalDateTime.now())) );
    }

    @Test
    public void add_8_item_should_send_an_email(){

        for (int i = 8; i >= 0; i--) {
            Assert.assertTrue( toDoList.addItem(new Item("test"+i, "", LocalDateTime.now().minusMinutes(30L *i))) );
        }
    }

}
