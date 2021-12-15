public class HongMiFactory implements PhoneFactory{
    @Override
    public Cpu getCpu() {
        return new Cpu.Cpu650();
    }

    @Override
    public Screen getScreen() {
        return new Screen.Screen5();
    }
}
