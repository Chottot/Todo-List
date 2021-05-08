import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ToDoList {
    public static final long MINIMUM_CREATION_TIME = 30;
    public static final short MAXIMUM_ITEM_LIST_SIZE = 10;

    private final ArrayList<Item> itemList;

    public ToDoList() {
        this.itemList = new ArrayList<>(MAXIMUM_ITEM_LIST_SIZE);
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

}
