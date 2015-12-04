import java.util.TreeSet;
import java.util.Arrays;
class Classic
{
    interface Capacity                      // ��������� ������� � �������
    {
        public double getCapacity();
    }
    public static class Base implements Capacity // 3 ������������������ ������������ �������
    {
        public double width; // 4 ��������� ���� ���� ����� ��������� � ���
        public double height;
        public double length;
        protected String logo;
        public double getCapacity() { return width * height * length; }
        public double getCapacity(double x) { return width * height * length * x; } // ���������� ������, ��� x - ����� �����������
    }
    public  static class Room extends Base        // �������� �������
    {
        public Capacity inner;     // ������ ������� ���� ���������� ������, ��� ����� ���������� �� ������ �������
        public double getCapacity() // 5 � (�����������) ������� getCapacity � ������ ����� ������� �� �������� ������ ����������� �������
        {
            double a = 0;
            try {
                a = super.getCapacity() - inner.getCapacity(); // �������� ����� super() ������ ����� ������ �� ������� �����, ������� ����� ������������ � �������� �������.
            } catch (ArithmeticException e) { System.out.println("��������� ������������ �������������� ��������"); }
            return a;
        }
    }
    public  static  class Box extends Base              // �������� ����
    {
        String color = "Blue";
        void Paint(String color)
        {
            this.color = color;  // this - ��� ��������� �� ������ �� �������� �� ��� ������
        }
    }
    public  static class Trailer extends  Base // ������ ���������
    {
        private boolean isFull;          // ��������� ���������� �� ����� ���� �����������
        public double getMass()
        {
            double mass =   1790 ;
            if (isFull) // �� ���� �������� � ������� ����� �� �����
                mass *= 2;         // ������� �� ���� ������� ����� � �����������
            return mass;
        }
    }

    public  static void bubbleSort (int[]arr)        // �������� ���������� ������� �����
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

    public static void Greetings()           // 2 ���������� � ������� ����������� �����
    {
        System.out.println("Hello World!"); // 1 ������� � ��������� ������ �����
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
        System.out.println("����� ����� : " + box1.getCapacity());
        box1.Paint("Red");
        System.out.println("���� : " + box1.color);
        System.out.println("����� ������� : " + workRoom.getCapacity());
        Trailer wroom = new Trailer();
        wroom.width = 6.0;
        wroom.height = 10.0;
        wroom.length = 18.0;
        wroom.logo = "Stoli";
        wroom.isFull = true;
        System.out.println("\n������������ ����� ������� : " + wroom.getMass() + "\n");
    }
    public static void main(String[] args)
    {
        Greetings();
        Initialisation();
        int[] array=new int[4];  // ������ ������ ��� ����������
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