import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class UserTest {

    @Test
    public void user_firstName_invalid_if_null(){
        User user = new User();
        Assert.assertThrows(IllegalArgumentException.class, () -> user.setFirstName(null));
    }

    @Test
    public void user_firstName_invalid_if_empty(){
        User user = new User();
        Assert.assertThrows(FirstNameEmptyException.class, () -> user.setFirstName(""));
    }

    @Test
    public void user_firstName_valid_if_not_empty() throws FirstNameEmptyException {
        User user = new User();
        user.setFirstName("Pierre");
    }

    @Test
    public void user_lastName_invalid_if_null(){
        User user = new User();
        Assert.assertThrows(IllegalArgumentException.class, () -> user.setLastName(null));
    }

    @Test
    public void user_lastName_invalid_if_empty(){
        User user = new User();
        Assert.assertThrows(LastNameEmptyException.class, () -> user.setLastName(""));
    }

    @Test
    public void user_lastName_valid_if_not_empty() throws LastNameEmptyException {
        User user = new User();
        user.setLastName("Paul");
    }

    @Test
    public void user_password_invalid_if_null(){
        User user = new User();
        Assert.assertThrows(IllegalArgumentException.class, () -> user.setPassword(null));
    }

    @Test
    public void user_password_invalid_less_than_8_char(){
        User user = new User();
        Assert.assertThrows(PasswordTooShortException.class, () -> user.setPassword(""));
    }

    @Test
    public void user_password_invalid_more_than_40_char(){
        User user = new User();
        Assert.assertThrows(PasswordTooLongException.class, () -> user.setPassword("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    public void user_password_valid_if_between_8_and_40_char() throws PasswordTooLongException, PasswordTooShortException {
        User user = new User();
        user.setPassword("banana12345");
    }

    @Test
    public void user_email_invalid_if_null(){
        User user = new User();
        Assert.assertThrows(IllegalArgumentException.class, () -> user.setEmail(null));
    }

    @Test
    public void user_email_invalid_if_empty(){
        User user = new User();
        Assert.assertThrows(EmailInvalidException.class, () -> user.setEmail(""));
    }

    @Test
    public void user_email_invalid_if_wrong_format(){
        User user = new User();
        Assert.assertThrows(EmailInvalidException.class, () -> user.setEmail("test.com"));
    }

    @Test
    public void user_email_valid_if_good_format() throws EmailInvalidException {
        User user = new User();
        user.setEmail("test@gmail.com");
    }

    @Test
    public void user_birthDate_invalid_if_less_than_13_year_old(){
        User user = new User();
        Assert.assertThrows(TooYoungException.class, () -> user.setBirthDate(LocalDate.now().minusYears(12)));
    }

    @Test
    public void user_birthDate_valid_if_13_year_old() throws TooYoungException {
        User user = new User();
        user.setBirthDate(LocalDate.now().minusYears(13));
    }

    @Test
    public void user_birthDate_valid_if_more_than_13_year_old() throws TooYoungException {
        User user = new User();
        user.setBirthDate(LocalDate.now().minusYears(14));
    }


}
