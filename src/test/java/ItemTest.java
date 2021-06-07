import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {


    @Test
    public void item_should_be_invalid_with_null_name(){
        Item item = new Item("", "", LocalDateTime.now());
        assertThrows(IllegalArgumentException.class, () -> item.setName(null));
    }

    @Test
    public void item_should_be_invalid_with_empty_name(){
        Item item = new Item("", "", LocalDateTime.now());
        assertThrows(NameEmptyException.class, () -> item.setName(""));
    }

    @Test
    public void item_should_be_valid_with_not_empty_name() {
        Item item = new Item("tes", "", LocalDateTime.now());
        assertDoesNotThrow( () -> item.setName("test"));
    }

    @Test
    public void item_should_be_valid_no_content() {
        Item item = new Item("test", "", LocalDateTime.now());
        assertDoesNotThrow( () -> item.setContent(""));
    }

    @Test
    public void item_should_be_valid_with_content_of_1000_length()  {
        Item item = new Item("test", "", LocalDateTime.now());

        String content = "";
        for (int i = 0; i < Item.MAXIMUM_CONTENT_LENGTH ; i++) {
            content = content.concat("a");
        }

        String finalContent = content;
        assertDoesNotThrow( () -> item.setContent(finalContent));
    }

    @Test
    public void item_should_be_valid_with_content_of_less_than_1000_length() {
        Item item = new Item("test", "", LocalDateTime.now());

        String content = "";
        for (int i = 0; i < Item.MAXIMUM_CONTENT_LENGTH - 1; i++) {
            content = content.concat("a");
        }
        String finalContent = content;
        assertDoesNotThrow( () -> item.setContent(finalContent));

    }

    @Test
    public void item_should_be_invalid_with_content_of_more_than_1000_length(){
        Item item = new Item("test", "", LocalDateTime.now());

        String content = "";
        for (int i = 0; i <= Item.MAXIMUM_CONTENT_LENGTH + 1; i++) {
            content = content.concat("a");
        }

        String finalContent = content;
        assertThrows( ContentToLongException.class, () -> item.setContent(finalContent));
    }

}


