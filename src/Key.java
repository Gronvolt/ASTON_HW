//Дополнительный класс Key для формирования ключа
public class Key {
    private final int key;

    public Key(int key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Key key1 = (Key) o;
        return key == key1.key;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(key);
    }
}
