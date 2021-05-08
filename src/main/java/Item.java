import java.time.LocalDateTime;

public class Item {

    public static final int MAXIMUM_CONTENT_LENGTH = 1000;

    private String name;
    private String content;
    private final LocalDateTime creationDate;

    public Item(String name, String content, LocalDateTime creationDate) {
        this.name = name;
        this.content = content;
        this.creationDate = creationDate;
    }

    public boolean setName(String name) {
        if( name.isEmpty() ){
            return false;
        }
        this.name = name;
        return true;
    }

    public boolean setContent(String content){
        if( content.length() > MAXIMUM_CONTENT_LENGTH){
            return false;
        }else{
            this.content = content;
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
