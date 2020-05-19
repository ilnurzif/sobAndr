package geek;

public class MainTask2 {
    public static void main(String[] args) {
        Report report = new Report();
        report.calculate();
        report.output(new PrintReport());
        report.output(new ScreenViewReport());
    }
}
