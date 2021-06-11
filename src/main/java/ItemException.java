public class ItemException extends Exception {
    public ItemException(String message) {
        super(message);
    }
}

class ContentToLongException extends ItemException {
    public ContentToLongException(int length) {
        super("the content must not be longer than" + Item.MAXIMUM_CONTENT_LENGTH + " but your is: " + length);
    }
}

class NameEmptyException extends ItemException {
    public NameEmptyException() {
        super("you need to specifies a name");
    }
}
