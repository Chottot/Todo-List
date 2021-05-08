import java.time.LocalDate;

public class User {
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
        return true;
    }

    public boolean isBirthDateValid(){
        return isBirthDateValid(LocalDate.now());
    }

    public boolean isEmailValid(){
        return !email.isEmpty();
    }

    public boolean isPasswordValid(){
        return !password.isEmpty();
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
