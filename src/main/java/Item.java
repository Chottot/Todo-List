import org.jetbrains.annotations.NotNull;

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

    public void setName(@NotNull String name) throws NameEmptyException {
        if( name.isEmpty() ){
            throw new NameEmptyException();
        }else{
            this.name = name;
        }
    }

    public void setContent(String content) throws ContentToLongException {
        if( content.length() > MAXIMUM_CONTENT_LENGTH){
            throw new ContentToLongException(content.length());
        }else{
            this.content = content;
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
