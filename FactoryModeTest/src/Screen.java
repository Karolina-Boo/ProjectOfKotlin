public interface Screen {
    void size();

    class Screen5 implements Screen {
        @Override
        public void size() {
            System.out.println("Screen: 5");
        }
    }

    class Screen6 implements Screen {
        @Override
        public void size() {
            System.out.println("Screen: 6");
        }
    }
}
