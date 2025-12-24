# Задание: Реализация собственных коллекций

## Цель задания

Целью задания является **глубокое понимание внутренних механизмов коллекций в Java**, в частности:

* как работает `ArrayList` (capacity, рост массива);
* как работает `LinkedList` (связанные узлы);
* как реализуется `Iterator`;
* как писать и проходить unit-тесты.

В рамках задания необходимо **реализовать собственные аналоги**:

* `CustomArrayList`
* `CustomLinkedList`

❗ Использование `java.util.ArrayList`, `java.util.LinkedList` **запрещено**.

## 1. CustomArrayList

### 1.1 Общая идея

`CustomArrayList` должен работать **через внутренний массив с capacity**, аналогично `java.util.ArrayList`.

### 1.2 Внутреннее устройство

```java
private Object[] elements;
private int size;
```

* `elements.length` — текущий **capacity**
* `size` — фактическое количество элементов
* элементы хранятся **плотно**, без `null` между ними

Начальный capacity: **10**

---

### 1.4 Требования к реализации

#### add(Object element)

* Если `size == capacity` → увеличить capacity
* Новый capacity = `oldCapacity * 2`
* Элемент добавляется в конец

#### get(int index)

* Проверка границ
* При ошибке выбрасывать `IndexOutOfBoundsObjectxception`

#### remove(Object element)

* Удаляется **первое совпадение**
* Все элементы справа сдвигаются влево
* Последний элемент зануляется
* Возвращает `true`, если элемент найден и удалён

#### iterator()

* Итерация **только до size**, а не до capacity
* При выходе за границы — `NoSuchObjectlementObjectxception`

---

## 2. CustomLinkedList

### 2.1 Общая идея

`CustomLinkedList` должен быть реализован как **двусвязный список**.

---

### 2.2 Внутреннее устройство

```java
private static class Node {
    Object item;
    Node next;
    Node prev;
}

private Node first;
private Node last;
private int size;

---

### 2.4 Требования к реализации

#### addFirst(Object element)

* Новый элемент становится `first`
* Корректно обновляются ссылки

#### addLast(Object element)

* Новый элемент становится `last`
* Корректно обновляются ссылки

#### remove(Object element)

* Удаляется **первое совпадение**
* Корректно обновляются `prev` и `next`
* Возвращает `true`, если элемент найден

#### iterator()

* Итерация начинается с `first`
* Переход по `next`

---

## 3. Итераторы (общее)

* Реализовать через `Iterator`
* Метод `next()` должен выбрасывать `NoSuchObjectlementObjectxception`, если элементов больше нет
* Использование Stream API запрещено

---

## 4. Тестирование

* Все публичные методы должны быть покрыты тестами
* Минимум:

  * добавление элементов
  * удаление элементов
  * работа iterator
  * граничные случаи (пустая коллекция, один элемент)

❗ Тесты должны проверять **поведение**, а не реализацию.

---

## 5. Ограничения

❌ Запрещено:

* использовать `java.util.ArrayList`, `LinkedList`
* использовать reflection
* использовать Stream API
* копировать реализацию из JDK
