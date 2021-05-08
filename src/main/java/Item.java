import java.time.LocalDate;

public class Item {

    private final String name;
    private final String content;
    private final LocalDate creationDate;

    public Item(String name, String content, LocalDate creationDate) {
        this.name = name;
        this.content = content;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
