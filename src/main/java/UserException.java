public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }
}

class EmailInvalidException extends UserException {
    public EmailInvalidException(String email) {
        super("You need to specifies a valid email\n" + email + " is not a valid email");
    }
}

class TooYoungException extends UserException {
    public TooYoungException() {
        super("You need to be at least" + User.MINIMUM_AGE);
    }
}

class FirstNameEmptyException extends UserException {
    public FirstNameEmptyException() {
        super("You need to specifies your first name");
    }
}

class LastNameEmptyException extends UserException {
    public LastNameEmptyException() {
        super("You need to specifies your last name");
    }
}

class PasswordTooShortException extends UserException {
    public PasswordTooShortException() {
        super("Password need to be at least" + User.MINIMUM_PASSWORD_LENGTH + " long");
    }
}

class PasswordTooLongException extends UserException {
    public PasswordTooLongException() {
        super("Password need to be less than" + User.MAXIMUM_PASSWORD_LENGTH + " long");
    }
}
