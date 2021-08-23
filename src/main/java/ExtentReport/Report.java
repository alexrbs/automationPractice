package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

public class Report {
    private static final ExtentReports extent = ReportFactory.getInstance();
    private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void createTest(String testName, ReportType type){
        ExtentTest extentTest = extent.createTest(testName);

        if(type.equals(ReportType.SINGLE)){
            test.set(extentTest);
            return;
        }

        parentTest.set(extentTest);
    }

    public static void createStep(String stepName){
        try{
            ExtentTest child = parentTest.get().createNode(stepName);
            test.set(child);
        }catch (NullPointerException ignored){
            ignored.printStackTrace();
        }
    }

    public static void log(Status status, String message){
        if(existsInstance()){
            return;
        }

        test.get().log(status, message);
    }

    public static void log(Status status, String message, MediaEntityModelProvider capture){
        if(existsInstance()){
            return;
        }

        test.get().log(status, message, capture);
    }

    public static boolean existsInstance(){
        if(test.get() == null){
            return true;
        }

        return false;
    }

    public static void close(){
        if(existsInstance()){
            return;
        }

        extent.flush();
    }
}
