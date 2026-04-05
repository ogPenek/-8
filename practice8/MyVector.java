public class MyVector {
    private Object[] data;
    private int size;

    public MyVector(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new InvalidCapacityException("Початкова місткість не може бути: " + initialCapacity);
        }
        this.data = new Object[initialCapacity];
        this.size = 0;
    }

    public int getSize() { return size; }

    public void add(Object element) {
        ensureCapacity();
        data[size++] = element;
    }

    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new VectorIndexOutOfBoundsException("Спроба додати за індексом " + index + ", але розмір " + size);
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new VectorIndexOutOfBoundsException("Невірний індекс: " + index);
        }
        return data[index];
    }

    public void remove(int index) throws EmptyVectorException {
        if (size == 0) {
            throw new EmptyVectorException("Вектор порожній, видалення неможливе!");
        }
        if (index < 0 || index >= size) {
            throw new VectorIndexOutOfBoundsException("Індекс поза межами: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public void clear() {
        this.data = new Object[10];
        this.size = 0;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = (data.length == 0) ? 10 : data.length * 2;
            Object[] newData = new Object[newCapacity];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("] (size: " + size + ")");
    }
}