import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ToDoList {
    public static final long MINIMUM_CREATION_TIME = 30;
    public static final short MAXIMUM_ITEM_LIST_SIZE = 10;
    public static final short ITEM_LIST_SIZE_EMAIL_TRIGGER = 8;

    private final ArrayList<Item> itemList;
    //test2

    public ToDoList() {
        this(new ArrayList<>(MAXIMUM_ITEM_LIST_SIZE));
    }

    public ToDoList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item item) throws ItemsCapacityException, ItemNameExistException, TimeBetweenInsertionException {
        if (itemList.size() >= MAXIMUM_ITEM_LIST_SIZE) {
            throw new ItemsCapacityException();
        }

        long minimumTime = Long.MAX_VALUE;
        for (Item i : itemList) {
            if (i.getName().equals(item.getName())) {
                throw new ItemNameExistException(i.getName());
            } else {
                long time = i.getCreationDate().until(item.getCreationDate(), ChronoUnit.MINUTES);
                if (time < minimumTime) {
                    minimumTime = time;
                }
            }
        }

        if (minimumTime < MINIMUM_CREATION_TIME) {
            throw new TimeBetweenInsertionException();
        }
        itemList.add(item);
    }

    public boolean shouldSendEmail() {
        return itemList.size() == ITEM_LIST_SIZE_EMAIL_TRIGGER;
    }

}
