public interface Cpu {
    void run();

    class Cpu650 implements Cpu{
        @Override
        public void run() {
            System.out.println("CPU：625");
        }
    }

    class Cpu825 implements Cpu{

        @Override
        public void run() {
            System.out.println("CPU: 825");
        }
    }
}




