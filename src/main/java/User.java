import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.apache.commons.validator.routines.EmailValidator;

public class User {

    public static final int MINIMUM_PASSWORD_LENGTH = 8;
    public static final int MAXIMUM_PASSWORD_LENGTH = 40;
    public static final int MINIMUM_AGE = 13;

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final LocalDate birthDate;

    public User(String firstName, String lastName, String email, String password, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public boolean isBirthDateValid(LocalDate currentDate){
        return birthDate.until(currentDate, ChronoUnit.YEARS) >= MINIMUM_AGE;
    }

    public boolean isBirthDateValid(){
        return isBirthDateValid(LocalDate.now());
    }

    public boolean isEmailValid(){
        return EmailValidator.getInstance().isValid(email);
    }

    public boolean isPasswordValid(){
        return password.length() >= MINIMUM_PASSWORD_LENGTH && password.length() <= MAXIMUM_PASSWORD_LENGTH;
    }

    public boolean isFirstNameValid(){
        return !firstName.isEmpty();
    }

    public boolean isLastNameValid(){
        return !lastName.isEmpty();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
