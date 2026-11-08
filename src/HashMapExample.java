
//Основной класс импровизированной HashMap'ы
public class HashMapExample {
    private final int BASIC_CAPACITY = 16;
    private final Entry[] array = new Entry[BASIC_CAPACITY];

    //Метод вставки нового элемента
    public void put(Integer key, Object value) {

        if (key == null || value == null) return;

        Key currentKey = new Key(key);
        int index = Math.floorMod(currentKey.hashCode(), BASIC_CAPACITY);

        //Если ячейка пустая - просто вставляем новый элемент
        if (array[index] == null) {
            array[index] = new Entry(currentKey, value, null);
            return;
        }

        Entry currentEntry = array[index];

        //Если в ячейке не один элемент, то проходим циклом по всем нодам
        while (currentEntry != null) {
            //Если ключ совпал - обновляем значение
            if (currentEntry.getKey().equals(currentKey)) {
                currentEntry.updateValue(value);
                return;
            }

            //Если это последняя нода на ветке, то новую ставим в конец
            if (currentEntry.getNext() == null) {
                currentEntry.setNext(new Entry(currentKey, value, null));
                return;
            } else {
                currentEntry = currentEntry.getNext();
            }
        }
    }

    //Метод получения элемента
    public Object get(Integer key) {

        if (key == null) throw new IllegalArgumentException("Key must not be null");

        Key currentKey = new Key(key);
        int index = Math.floorMod(currentKey.hashCode(), BASIC_CAPACITY);

        if (array[index] != null) {
            Entry currentEntry = array[index];

            //С помощью цикла ищем совпадающий по ключу элемент
            while (currentEntry != null) {
                if (currentEntry.getKey().equals(currentKey)) {
                    return currentEntry.getValue();
                }
                currentEntry = currentEntry.getNext();
            }
        }
        return null;
    }

    //Метод удаления элемента
    public Object remove(Integer key) {

        if (key == null) throw new IllegalArgumentException("Key must not be null");

        Key currentKey = new Key(key);
        int index = Math.floorMod(currentKey.hashCode(), BASIC_CAPACITY);

        if (array[index] == null) {
            return null;
        }

        //Храним текущей и предыдущей ноды для замены ссылок
        Entry currentEntry = array[index];
        Entry previousEntry = null;

        //С помощью цикла ищем подходящую по ключу ноду, которую хотим удалить
        while (currentEntry != null) {
            if (currentEntry.getKey().equals(currentKey)) {
                if (previousEntry != null) {
                    //Удаление из середины
                    previousEntry.setNext(currentEntry.getNext());
                    //Удаление из головы
                } else array[index] = currentEntry.getNext();
                       //Удаление с хвоста
                return currentEntry.getValue();
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.getNext();
        }
        return null;
    }
}

