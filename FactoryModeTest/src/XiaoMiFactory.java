public class XiaoMiFactory implements PhoneFactory{
    @Override
    public Cpu getCpu() {
        return new Cpu.Cpu825();
    }

    @Override
    public Screen getScreen() {
        return new Screen.Screen6();
    }
}
