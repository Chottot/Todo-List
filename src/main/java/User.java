import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.apache.commons.validator.routines.EmailValidator;

public class User {

    public static final int MINIMUM_PASSWORD_LENGTH = 8;
    public static final int MAXIMUM_PASSWORD_LENGTH = 40;
    public static final int MINIMUM_AGE = 13;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private final ToDoList toDoList;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.birthDate = null;
        this.toDoList = new ToDoList();
    }

    public User(String firstName,
                String lastName,
                String email,
                String password,
                LocalDate birthDate,
                ToDoList toDoList) throws UserException {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setBirthDate(birthDate);
        this.toDoList = toDoList;
    }

    public User(String firstName,
                String lastName,
                String email,
                String password,
                LocalDate birthDate) throws UserException {
        this(firstName, lastName, email, password, birthDate, new ToDoList());
    }

    public void addItem(Item item) throws ItemsCapacityException, TimeBetweenInsertionException, ItemNameExistException {
        toDoList.addItem(item);
        if (toDoList.shouldSendEmail()) {
            sendEmail();
        }
    }

    public void sendEmail() {
        EmailSenderService.sendEmail();
    }

    public void setFirstName(String firstName) throws FirstNameEmptyException {
        if (firstName == null) {
            throw new IllegalArgumentException();
        } else if (firstName.isEmpty()) {
            throw new FirstNameEmptyException();
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) throws LastNameEmptyException {
        if (lastName == null) {
            throw new IllegalArgumentException();
        } else if (lastName.isEmpty()) {
            throw new LastNameEmptyException();
        } else {
            this.lastName = lastName;
        }
    }

    public void setEmail(String email) throws EmailInvalidException {
        if (email == null) {
            throw new IllegalArgumentException();
        } else if (!EmailValidator.getInstance().isValid(email)) {
            throw new EmailInvalidException(email);
        } else {
            this.email = email;
        }
    }

    public void setPassword(String password) throws PasswordTooShortException, PasswordTooLongException {
        if (password == null) {
            throw new IllegalArgumentException();
        } else if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            throw new PasswordTooShortException();
        } else if (password.length() > MAXIMUM_PASSWORD_LENGTH) {
            throw new PasswordTooLongException();
        }
        this.password = password;
    }

    public void setBirthDate(LocalDate birthDate) throws TooYoungException {
        if (birthDate == null) {
            throw new IllegalArgumentException();
        } else if (birthDate.until(LocalDate.now(), ChronoUnit.YEARS) < MINIMUM_AGE) {
            throw new TooYoungException();
        } else {
            this.birthDate = birthDate;
        }
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


