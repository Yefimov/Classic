import java.util.TreeSet;
import java.util.Arrays;
class Classic
{
    interface Capacity                      // Интерфейс объекта с объёмом
    {
        public double getCapacity();
    }
    public static class Base implements Capacity // 3 Продемонстрировать наследование классов
    {
        public double width; // 4 Применить поля всех видов видимости в них
        public double height;
        public double length;
        protected String logo;
        public double getCapacity() { return width * height * length; }
        public double getCapacity(double x) { return width * height * length * x; } // Перегрузка метода, где x - некий коэффициент
    }
    public  static class Room extends Base        // Объёмная комната
    {
        public Capacity inner;     // Внутри комнаты есть внутренний объект, чей объём вычитается из объёма комнаты
        public double getCapacity() // 5 Я (полиморфизм) функцию getCapacity и теперь объем комнаты не включает объема внутреннего объекта
        {
            double a = 0;
            try {
                a = super.getCapacity() - inner.getCapacity(); // Ключевое слово super() являет собой ссылку на базовый класс, которую можно использовать в дочерних классах.
            } catch (ArithmeticException e) { System.out.println("Произошла недопустимая арифметическая операция"); }
            return a;
        }
    }
    public  static  class Box extends Base              // Объёмный ящик
    {
        String color = "Blue";
        void Paint(String color)
        {
            this.color = color;  // this - это указатель на объект из которого он был вызван
        }
    }
    public  static class Trailer extends  Base // Прицеп грузовика
    {
        private boolean isFull;          // Приватные переменные не видны даже наследникам
        public double getMass()
        {
            double mass =   1790 ;
            if (isFull) // Ну типа нагружен и быстрее ехать не может
                mass *= 2;         // Формула не несёт никакой связи с реальностью
            return mass;
        }
    }

    public  static void bubbleSort (int[]arr)        // Алгоритм сортировки массива строк
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
    public  static class Employee implements Comparable {
        String str;
        int number;
        Employee(String str, int number) {
            this.str = str;
            this.number = number;
        }
        @Override
        public int compareTo(Object obj) {
            Employee entry = (Employee) obj;
            int result = str.compareTo(entry.str);
            if(result == 0) {
                result = number - entry.number;
            }
            return result;
        }
    }

    public static void Greetings()           // 2 Определить и вызвать статический метод
    {
        System.out.println("Hello World!"); // 1 Вывести в командную строку текст
    }
    public static void Initialisation()
    {
        Box box1 = new Box();
        box1.width = 1.0;
        box1.height = 2.0;
        box1.length = 3.0;
        Room workRoom = new Room();
        workRoom.width = 10.0;
        workRoom.height = 20.0;
        workRoom.length = 30.0;
        workRoom.inner = box1;
        System.out.println("Объем ящика : " + box1.getCapacity());
        box1.Paint("Red");
        System.out.println("Цвет : " + box1.color);
        System.out.println("Объем комнаты : " + workRoom.getCapacity());
        Trailer wroom = new Trailer();
        wroom.width = 6.0;
        wroom.height = 10.0;
        wroom.length = 18.0;
        wroom.logo = "Stoli";
        wroom.isFull = true;
        System.out.println("\nМаксимальная масса прицепа : " + wroom.getMass() + "\n");
    }
    public static void main(String[] args)
    {
        Greetings();
        Initialisation();
        int[] array=new int[4];  // Создаём массив для сортировки
        array[0] = 1;
        array[1] = 9;
        array[2] = 9;
        array[3] = 5;
        bubbleSort(array);
        for(int i=0;i<array.length; i++)
        {
            System.out.println(array[i]);
        }


        TreeSet<Employee> ex = new TreeSet<Employee>();
        ex.add(new Employee("Ivan Ivanov", 121));
        ex.add(new Employee("Ivan Ivanov", 221));
        ex.add(new Employee("Maria Antonova", 3213));
        ex.add(new Employee("Valentin Suslov", 3123));
        ex.add(new Employee("Nikolay Rubenshtam", 88786));
        ex.add(new Employee("Arbuz Bukva", 88787));
        for(Employee e : ex) {
            System.out.println("Str: " + e.str + ", number: " + e.number);
        }
    }
}