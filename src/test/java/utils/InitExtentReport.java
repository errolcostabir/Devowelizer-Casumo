package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InitExtentReport {

    TestContextSetup testContextSetup;

    public InitExtentReport(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    //method that initializes the Extent report
    public void initializeExtentReport(){
        Date currentDate=new Date(); //creating an object of date
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyy_HH-mm-ss"); //creating object of the formatter
        String fileName=formatter.format(currentDate).toString(); //setting the filename
        testContextSetup.sparkReporter=new ExtentSparkReporter(new File("./Reports/"+fileName+".html"));
        testContextSetup.report=new ExtentReports();
        testContextSetup.report.attachReporter(testContextSetup.sparkReporter);
    }
}
