public class ToDoListException extends Exception {
    public ToDoListException(String message) {
        super(message);
    }
}

class ItemsCapacityException extends ToDoListException {
    public ItemsCapacityException() {
        super(String.format(
                "You have reached the maximum capacity of the list : %d",
                ToDoList.MAXIMUM_ITEM_LIST_SIZE
        ));
    }
}

class ItemNameExistException extends ToDoListException {
    public ItemNameExistException(String name) {
        super(String.format(
                "Object %s exists in the list",
                name
        ));
    }
}

class TimeBetweenInsertionException extends ToDoListException {
    public TimeBetweenInsertionException() {
        super(String.format(
                "Time between insertions is %d minutes",
                ToDoList.MINIMUM_CREATION_TIME
        ));
    }
}