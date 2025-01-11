package com.webclient.Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webclient.Utilities.BrowserUtils;
import com.webclient.Utilities.ConfigurationReader;
import com.webclient.Utilities.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


public class WebclientTest extends BasePage {
    @Before
    public void setUp(){

        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        report = new ExtentReports();
        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Webclient Report");

        //set environment information
        report.setSystemInfo("Environment","Test");
        report.setSystemInfo("BrowserType", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }

    @Test
    public void TC001() {
        extentLogger = report.createTest("Test Case 1: Uygulamaya Login Olma");
        extentLogger.info("https://catchylabs-webclient.testinium.com/ sitesi açılır");
        mainPage();

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        checkPageisOpen("login");

        extentLogger.info("Uygulamaya Login olunur");
        enterCredentials();
        extentLogger.info("Uygulama sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("apps");
    }


    @Test
    public void TC002() {
        extentLogger = report.createTest("Test Case 2: Para Transferi");
        extentLogger.info("https://catchylabs-webclient.testinium.com/ sitesi açılır");
        mainPage();

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        checkPageisOpen("login");

        extentLogger.info("Uygulamaya Login olunur");
        enterCredentials();
        extentLogger.info("Uygulama sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("apps");
        extentLogger.info("My account sayfasına gidilir.");
        clickMoneyTransferButton();

        extentLogger.info("My Account sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("money-transfer");

        extentLogger.info("Money Transfer sayfasına gidilir.");
        transferMoneyButton();

        extentLogger.info("Tutar yazılır");
        sendAmountTransfer("100");

        extentLogger.info("Send butonuna tıklanır");
        sendButton();

        extentLogger.info("Transfer miktarı kontrol edilir");
        transferAmountCheck();


    }

    @Test
    public void TC003() {
        extentLogger = report.createTest("Test Case 3: Kredi Kartı Zorunlu Alanlar Kontrolü");
        extentLogger.info("https://catchylabs-webclient.testinium.com/ sitesi açılır");
        mainPage();

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        checkPageisOpen("login");

        extentLogger.info("Uygulamaya Login olunur");
        enterCredentials();
        extentLogger.info("Uygulama sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("apps");
        extentLogger.info("My account sayfasına gidilir.");
        clickMoneyTransferButton();

        extentLogger.info("My Account sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("money-transfer");

        extentLogger.info("Kredi Kartı ile para yükleme sayfasına gidilir.");
        clickAddMoneyButton();

        extentLogger.info("Add butona tıklanır");
        clickAddButton();

        extentLogger.info("Required ikazının var olduğu kontrol edilir.");
        requiredisDisplayed();

    }

    @Test
    public void TC004() {
        extentLogger = report.createTest("Test Case 4: Kredi Kartı ile Para Ekleme");
        extentLogger.info("https://catchylabs-webclient.testinium.com/ sitesi açılır");
        mainPage();

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        checkPageisOpen("login");

        extentLogger.info("Uygulamaya Login olunur");
        enterCredentials();
        extentLogger.info("Uygulama sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("apps");
        extentLogger.info("My account sayfasına gidilir.");
        clickMoneyTransferButton();

        extentLogger.info("My Account sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("money-transfer");

        extentLogger.info("Kredi Kartı ile para yükleme sayfasına gidilir.");
        clickAddMoneyButton();

        extentLogger.info("Kredi Kartı numarası girilir.");
        cardNumber("1234123412341234");

        extentLogger.info("Kredi Kartı ismi girilir.");
        cardHolder("Otomasyon Test");

        extentLogger.info("Kredi Kartı son kullanım tarihi girilir.");
        expireDate("1026");

        extentLogger.info("Kredi Kartı cvv girilir.");
        cvvNo("110");

        extentLogger.info("Miktar girilir.");
        amount("10000");

        extentLogger.info("Add butona tıklanır");
        clickAddButton();

        extentLogger.info("Gönderilen miktar kontrol edilir");
        checkAmount();
    }

    @Test
    public void TC005() {
        extentLogger = report.createTest("Test Case 5: Hesap İsmi Düzenleme");
        extentLogger.info("https://catchylabs-webclient.testinium.com/ sitesi açılır");
        mainPage();

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        checkPageisOpen("login");

        extentLogger.info("Uygulamaya Login olunur");
        enterCredentials();
        extentLogger.info("Uygulama sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("apps");
        extentLogger.info("My account sayfasına gidilir.");
        clickMoneyTransferButton();

        extentLogger.info("My Account sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("money-transfer");

        extentLogger.info("Edit Account sayfasına gidilir.");
        checkPageisOpen("money-transfer");

        extentLogger.info("Account name update edilerek kontrol edilir.");
        editAccountPage();
    }

    @Test
    public void TC006() throws InterruptedException {
        extentLogger = report.createTest("Test Case 6: 0 birim para transferi gerçekleştirme.");
        extentLogger.info("https://catchylabs-webclient.testinium.com/ sitesi açılır");
        mainPage();

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        checkPageisOpen("login");

        extentLogger.info("Uygulamaya Login olunur");
        enterCredentials();
        extentLogger.info("Uygulama sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("apps");
        extentLogger.info("My account sayfasına gidilir.");
        clickMoneyTransferButton();

        extentLogger.info("My Account sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("money-transfer");

        extentLogger.info("Send butonuna tıklanarak para transferi yapılıp yapılamayacağı kontrol edilir.");
        check0moneyTransfer("-100");

    }

    @Test
    public void TC007() throws InterruptedException {
        extentLogger = report.createTest("Test Case 7: Kredi Kartı ile 0 birim Para Ekleme");
        extentLogger.info("https://catchylabs-webclient.testinium.com/ sitesi açılır");
        mainPage();

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        checkPageisOpen("login");

        extentLogger.info("Uygulamaya Login olunur");
        enterCredentials();
        extentLogger.info("Uygulama sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("apps");
        extentLogger.info("My account sayfasına gidilir.");
        clickMoneyTransferButton();

        extentLogger.info("My Account sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("money-transfer");

        extentLogger.info("Kredi kartı ile hesaba 0 birim para yüklemesi kontrol edilir.");
        add0moneyTransfer("0");

    }

    @Test
    public void TC008() throws InterruptedException {
        extentLogger = report.createTest("Test Case 8: Negatif Bakiye Kontrolü");
        extentLogger.info("https://catchylabs-webclient.testinium.com/ sitesi açılır");
        mainPage();

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        checkPageisOpen("login");

        extentLogger.info("Uygulamaya Login olunur");
        enterCredentials();
        extentLogger.info("Uygulama sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("apps");
        extentLogger.info("My account sayfasına gidilir.");
        clickMoneyTransferButton();

        extentLogger.info("My Account sayfasının açıldığı kontrol edilir.");
        checkPageisOpen("money-transfer");

        extentLogger.info("Kredi kartı ile hesaba 0 birim para yüklemesi kontrol edilir.");
        negatifAmountMoneyCheck();

    }
    @After
    public void endTest() {
        BrowserUtils.getScreenshot("Test Sonucu");
        Driver.closeDriver();
        report.flush();
    }
}
