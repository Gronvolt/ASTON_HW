public class Entry {
    private final Key key;
    private Object value;
    private Entry next;

    public Entry(Key key, Object value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Key getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Entry getNext() {
        return next;
    }

    public void updateValue (Object newVal) {
        this.value = newVal;
    }

    public void setNext (Entry newNext) {
        this.next = newNext;
    }
}
