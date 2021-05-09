import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ToDoList {
    public static final long MINIMUM_CREATION_TIME = 30;
    public static final short MAXIMUM_ITEM_LIST_SIZE = 10;
    public static final short ITEM_LIST_SIZE_EMAIL_TRIGGER = 8;

    private final ArrayList<Item> itemList;

    public ToDoList() {
        this( new ArrayList<>(MAXIMUM_ITEM_LIST_SIZE) );
    }

    public ToDoList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public boolean addItem(Item item){
        if(itemList.size() >= MAXIMUM_ITEM_LIST_SIZE){
            return false;
        }

        long minimumTime = Long.MAX_VALUE;
        for (Item i:itemList) {
            if( i.getName().equals( item.getName())){
                return false;
            }else{
                long time = i.getCreationDate().until(item.getCreationDate(), ChronoUnit.MINUTES);
                if(time < minimumTime){
                    minimumTime = time;
                }
            }
        }

        if( minimumTime < MINIMUM_CREATION_TIME){
            return false;
        }
        itemList.add(item);
        return true;
    }

    public boolean shouldSendEmail(){
        return itemList.size() == ITEM_LIST_SIZE_EMAIL_TRIGGER;
    }

}
