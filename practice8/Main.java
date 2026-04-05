public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестування MyVector з виключеннями ===\n");

        try {
            System.out.println("Спроба створити вектор з розміром -5...");
            MyVector v = new MyVector(-5);
        } catch (InvalidCapacityException e) {
            System.out.println("Зловлено помилку: " + e.getMessage());
        }

        System.out.println("\n--- Створюємо коректний вектор ---");
        MyVector vector = new MyVector(5);
        vector.add("Java");
        vector.add("Kotlin");
        vector.print();

        try {
            System.out.println("\nОчищення вектора та спроба видалення...");
            vector.clear();
            vector.remove(0); 
        } catch (EmptyVectorException e) {
            System.out.println("Зловлено помилку (Checked): " + e.getMessage());
        }

        try {
            vector.add("Element");
            System.out.println("\nСпроба отримати 100-й елемент...");
            vector.get(100);
        } catch (VectorIndexOutOfBoundsException e) {
            System.out.println("Зловлено помилку (Runtime): " + e.getMessage());
        }

        try {
            System.out.println("\nПошук об'єкта 'Python', якого немає...");
            throw new ElementNotFoundException("Об'єкт 'Python' не знайдено у векторі!");
        } catch (ElementNotFoundException e) {
            System.out.println("Зловлено помилку: " + e.getMessage());
        }

        try {
            System.out.println("\nПеревірка сумісності типів...");
            throw new IncompatibleTypeException("Тип даних не відповідає очікуваному!");
        } catch (IncompatibleTypeException e) {
            System.out.println("Зловлено помилку: " + e.getMessage());
        }

        System.out.println("\n=== Тестування завершено ===");
    }
}