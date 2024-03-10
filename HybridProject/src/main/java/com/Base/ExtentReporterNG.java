package com.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObj() {
		String fp = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter rep=new ExtentSparkReporter(fp);
		rep.config().setReportName("web automatn title");
		rep.config().setDocumentTitle("Test result");
		ExtentReports ext = new ExtentReports();
		ext.attachReporter(rep);
		ext.setSystemInfo("Azar", "test");
		return ext;
		
				}
}
