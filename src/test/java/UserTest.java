import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void user_firstName_invalid_if_null(){
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setFirstName(null));
    }

    @Test
    public void user_firstName_invalid_if_empty(){
        User user = new User();
        assertThrows(FirstNameEmptyException.class, () -> user.setFirstName(""));
    }

    @Test
    public void user_firstName_valid_if_not_empty() {
        User user = new User();
        assertDoesNotThrow( () -> user.setFirstName("Pierre"));
    }

    @Test
    public void user_lastName_invalid_if_null(){
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setLastName(null));
    }

    @Test
    public void user_lastName_invalid_if_empty(){
        User user = new User();
        assertThrows(LastNameEmptyException.class, () -> user.setLastName(""));
    }

    @Test
    public void user_lastName_valid_if_not_empty() {
        User user = new User();
        assertDoesNotThrow( () -> user.setLastName("Paul"));
    }

    @Test
    public void user_password_invalid_if_null(){
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(null));
    }

    @Test
    public void user_password_invalid_less_than_8_char(){
        User user = new User();
        assertThrows(PasswordTooShortException.class, () -> user.setPassword(""));
    }

    @Test
    public void user_password_invalid_more_than_40_char(){
        User user = new User();
        assertThrows(PasswordTooLongException.class, () -> user.setPassword("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    public void user_password_valid_if_between_8_and_40_char() {
        User user = new User();
        assertDoesNotThrow( () -> user.setPassword("banana12345"));
    }

    @Test
    public void user_email_invalid_if_null(){
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setEmail(null));
    }

    @Test
    public void user_email_invalid_if_empty(){
        User user = new User();
        assertThrows(EmailInvalidException.class, () -> user.setEmail(""));
    }

    @Test
    public void user_email_invalid_if_wrong_format(){
        User user = new User();
        assertThrows(EmailInvalidException.class, () -> user.setEmail("test.com"));
    }

    @Test
    public void user_email_valid_if_good_format() {
        User user = new User();
        assertDoesNotThrow( () -> user.setEmail("test@gmail.com"));
    }

    @Test
    public void user_birthDate_invalid_if_less_than_13_year_old(){
        User user = new User();
        assertThrows(TooYoungException.class, () -> user.setBirthDate(LocalDate.now().minusYears(12)));
    }

    @Test
    public void user_birthDate_valid_if_13_year_old() {
        User user = new User();
        assertDoesNotThrow( () -> user.setBirthDate(LocalDate.now().minusYears(13)));
    }

    @Test
    public void user_birthDate_valid_if_more_than_13_year_old(){
        User user = new User();
        assertDoesNotThrow( () -> user.setBirthDate(LocalDate.now().minusYears(14)));
    }

    @Test
    public void should_send_an_email_when_the_8th_item_is_added(){
        User user = Mockito.spy(User.class);

        for (int i = 7; i >= 0; i--) {

            int finalI = i;
            assertDoesNotThrow(
                    () -> user.addItem(new Item("item"+ finalI, "", LocalDateTime.now().minusHours(finalI)))
            );
        }

        Mockito.verify(user,  Mockito.times(1)).sendEmail();
    }


}
