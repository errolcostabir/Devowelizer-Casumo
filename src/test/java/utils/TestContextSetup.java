package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestContextSetup {
    public ExtentReports report;
    public ExtentTest test;
    public ExtentSparkReporter sparkReporter;
}
