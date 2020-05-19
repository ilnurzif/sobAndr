package geek;

import java.util.*;

class PrintReport implements IOutputStrategy, IPrintMethod {
    public <T> void output(T items) {
        List<ReportItem> items_ = (List<ReportItem>) items;
        BaseReportAlg.doReport(items_, this);
    }

    @Override
    public <T> void printItem(T item) {
        ReportItem item_ = (ReportItem) item;
        System.out.format("printer %s - %f \n\r", item_.getDescription(), item_.getAmount());
    }

    @Override
    public void printTitle() {
        System.out.println("Output to printer");
    }
}