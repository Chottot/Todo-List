import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDateTime;

public class ItemTest {

    @Test
    public void item_should_be_invalid_with_empty_name(){
        Item item = new Item("", "", LocalDateTime.now());
        Assert.assertFalse(item.setName(""));
    }

    @Test
    public void item_should_be_valid_with_not_empty_name(){
        Item item = new Item("tes", "", LocalDateTime.now());
        Assert.assertTrue(item.setName("test"));
    }

    @Test
    public void item_should_be_valid_no_content(){
        Item item = new Item("test", "", LocalDateTime.now());
        Assert.assertTrue(item.setContent(""));
    }

    @Test
    public void item_should_be_valid_with_content_of_1000_length(){
        Item item = new Item("test", "", LocalDateTime.now());

        String content = "";
        for (int i = 0; i < Item.MAXIMUM_CONTENT_LENGTH ; i++) {
            content = content.concat("a");
        }
        System.out.println(content.length());
        Assert.assertTrue(item.setContent(content));
    }

    @Test
    public void item_should_be_valid_with_content_of_less_than_1000_length(){
        Item item = new Item("test", "", LocalDateTime.now());

        String content = "";
        for (int i = 0; i < Item.MAXIMUM_CONTENT_LENGTH - 1; i++) {
            content = content.concat("a");
        }
        Assert.assertTrue(item.setContent(content));
    }

    @Test
    public void item_should_be_invalid_with_content_of_more_than_1000_length(){
        Item item = new Item("test", "", LocalDateTime.now());

        String content = "";
        for (int i = 0; i <= Item.MAXIMUM_CONTENT_LENGTH + 1; i++) {
            content = content.concat("a");
        }
        Assert.assertFalse(item.setContent(content));
    }

}
