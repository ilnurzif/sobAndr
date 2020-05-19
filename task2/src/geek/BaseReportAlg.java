package geek;

import java.util.List;

public class BaseReportAlg {
    public static void doReport(List<ReportItem> items_, IPrintMethod printMethod) {
        printMethod.printTitle();
        for (ReportItem item : items_) {
            printMethod.printItem(item);
        }
    }
}
