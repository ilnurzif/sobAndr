package geek;

import java.util.List;

public class ScreenViewReport implements IOutputStrategy, IPrintMethod {
    @Override
    public <T> void output(T items) {
        List<ReportItem> items_ = (List<ReportItem>) items;
        BaseReportAlg.doReport(items_, this);
    }

    @Override
    public <T> void printItem(T item_) {
        ReportItem item = (ReportItem) item_;
        System.out.format("screen %s - %f \n\r", item.getDescription(), item.getAmount());
    }

    @Override
    public void printTitle() {
        System.out.println("Output to screen");
    }
}
