import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class UserTest {

    @Test
    public void user_firstName_invalid_if_empty(){
        User user = new User("", "", "", "", LocalDate.now());
        Assert.assertFalse(user.isFirstNameValid());
    }

    @Test
    public void user_firstName_valid_if_not_empty(){
        User user = new User("pierre", "", "", "", LocalDate.now());
        Assert.assertTrue(user.isFirstNameValid());
    }

    @Test
    public void user_lastName_invalid_if_empty(){
        User user = new User("", "", "", "", LocalDate.now());
        Assert.assertFalse(user.isLastNameValid());
    }

    @Test
    public void user_lastName_valid_if_not_empty(){
        User user = new User("", "paul", "", "", LocalDate.now());
        Assert.assertTrue(user.isLastNameValid());
    }

    @Test
    public void user_password_invalid_less_than_8_char(){
        User user = new User("", "", "", "1234567", LocalDate.now());
        Assert.assertFalse(user.isPasswordValid());
    }

    @Test
    public void user_password_invalid_more_than_40_char(){
        User user = new User("", "", "", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", LocalDate.now());
        Assert.assertFalse(user.isPasswordValid());
    }

    @Test
    public void user_password_valid_if_between_8_and_40_char(){
        User user = new User("", "", "", "banane12345", LocalDate.now());
        Assert.assertTrue(user.isPasswordValid());
    }

    @Test
    public void user_email_invalid_if_empty(){
        User user = new User("", "", "", "", LocalDate.now());
        Assert.assertFalse(user.isEmailValid());
    }

    @Test
    public void user_email_invalid_if_wrong_format(){
        User user = new User("", "", "test.com", "", LocalDate.now());
        Assert.assertFalse(user.isEmailValid());
    }

    @Test
    public void user_email_valid_if_good_format(){
        User user = new User("", "", "test@gmail.com", "", LocalDate.now());
        Assert.assertTrue(user.isEmailValid());
    }

    @Test
    public void user_birthDate_invalid_if_less_than_13_year_old(){
        User user = new User("", "", "", "", LocalDate.now().minusYears(12));
        Assert.assertFalse(user.isBirthDateValid());
    }

    @Test
    public void user_birthDate_valid_if_13_year_old(){
        User user = new User("", "", "", "", LocalDate.now().minusYears(13));
        Assert.assertTrue(user.isBirthDateValid());
    }

    @Test
    public void user_birthDate_valid_if_more_than_13_year_old(){
        User user = new User("", "", "", "", LocalDate.now().minusYears(14));
        Assert.assertTrue(user.isBirthDateValid());
    }


}
