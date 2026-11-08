public static void main(String[] args) {
    HashMapExample map = new HashMapExample();

    System.out.println("=== Добавление элементов ===");

    map.put(5, "A");
    map.put(21, "B");
    map.put(37, "C");
    map.put(53, "D");

    System.out.println("get(5): " + map.get(5));
    System.out.println("get(21): " + map.get(21));
    System.out.println("get(37): " + map.get(37));
    System.out.println("get(53): " + map.get(53));

    System.out.println("\n=== Обновление существующего ключа ===");

    map.put(21, "Updated");

    System.out.println("get(21): " + map.get(21));

    System.out.println("\n=== Добавление в другую цепочку ===");

    map.put(8, "E");
    map.put(24, "F");

    System.out.println("get(8): " + map.get(8));
    System.out.println("get(24): " + map.get(24));

    System.out.println("\n=== Добавление в конец длинной цепочки ===");

    map.put(69, "G");
    map.put(101, "H");

    System.out.println("get(69): " + map.get(69));
    System.out.println("get(101): " + map.get(101));

    System.out.println("\n=== Поиск отсутствующих ключей ===");

    System.out.println("get(10): " + map.get(10));
    System.out.println("get(85): " + map.get(85));



    //    Ожидаемый результат:
    //    === Добавление элементов ===
    //    get(5): A
    //    get(21): B
    //    get(37): C
    //    get(53): D
    //
    //    === Обновление существующего ключа ===
    //    get(21): Updated
    //
    //    === Добавление в другую цепочку ===
    //    get(8): E
    //    get(24): F
    //
    //    === Добавление в конец длинной цепочки ===
    //    get(69): G
    //    get(101): H
    //
    //    === Поиск отсутствующих ключей ===
    //    get(10): null
    //    get(85): null



    //    Перезапись значения
    System.out.println("=== TEST 1 ===");

    map.put(5, "First");
    map.put(5, "Second");
    map.put(5, "Third");

    System.out.println("get(5): " + map.get(5));
    //    Ожидаемое поведение: Third.

    //    Одинаковый hashCode, разные ключи
    System.out.println("=== TEST 2 ===");

    map.put(5, "A");
    map.put(21, "B");
    map.put(37, "C");

    System.out.println("get(5): " + map.get(5));
    System.out.println("get(21): " + map.get(21));
    System.out.println("get(37): " + map.get(37));

    //    Ожидаемое поведение:
    //- get(5) → A
    //- get(21) → B
    //- get(37) → C


    //    Удаление
    System.out.println("=== REMOVE TESTS ===");

    map.put(5, "A");
    map.put(21, "B");
    map.put(37, "C");
    map.put(53, "D");

    //    Удаление головы
    System.out.println("remove(5): " + map.remove(5));
    System.out.println("get(5): " + map.get(5));
    System.out.println("get(21): " + map.get(21));

    //    Удаление из середины
    System.out.println("remove(37): " + map.remove(37));
    System.out.println("get(37): " + map.get(37));
    System.out.println("get(53): " + map.get(53));

    //    Удаление хвоста
    System.out.println("remove(53): " + map.remove(53));
    System.out.println("get(53): " + map.get(53));

    //    Удаление отсутствующего ключа
    System.out.println("remove(100): " + map.remove(100));

    //    Проверка оставшегося элемента
    System.out.println("get(21): " + map.get(21));

    //=== REMOVE TESTS ===
    //remove(5): A
    //get(5): null
    //get(21): B
    //remove(37): C
    //get(37): null
    //get(53): D
    //remove(53): D
    //get(53): null
    //remove(100): null
    //get(21): B
}
