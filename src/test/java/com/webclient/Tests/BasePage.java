package com.webclient.Tests;

import com.webclient.Utilities.*;
import com.webclient.Utilities.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage extends TestBase {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    String prodPrice;


    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement password;
    @FindBy(xpath = "//div[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()='Open Money Transfer']")
    public WebElement openMoneyTransferButton;

    @FindBy(xpath = "//div[text()='Transfer money']")
    public WebElement transferMoneyButton;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    public WebElement amountPrice;

    @FindBy(xpath = "//div[text()='Send']")
    public WebElement sendButton;

    @FindBy(xpath = "//div[text()='100.00']")
    public WebElement transferAmount;

    @FindBy(xpath = "//div[text()='Add money']")
    public WebElement addMoneyButton;

    @FindBy(xpath = "//div[text()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//div[text()='Required']")
    public WebElement requiredWarning;

    @FindBy(xpath = "//*[@class='m-basket__remove btn-text']")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[text()='Sepetinizde Ürün Bulunmamaktadır']")
    public WebElement getMessage;

    public void mainPage() {
        Driver.get().get(ConfigurationReader.get("url"));

        //Açılıştaki cookies kapatılır
//        BrowserUtils.waitForClickablility(cookies_Loc, 5);
//        cookies_Loc.click();
    }

    public void enterCredentials() {
        username.click();
        username.sendKeys(ConfigurationReader.get("KullaniciAdi"));
        password.click();
        password.sendKeys(ConfigurationReader.get("Sifre"));
        loginButton.click();
        BrowserUtils.waitFor(2);
    }
    public void checkPageisOpen(String title) {
        String actualTitle = Driver.get().getTitle();
        System.out.println("Page title is: " + actualTitle);
        //Sayfada olduğumuzu assert ediyoruz
        Assert.assertEquals(title, actualTitle);
    }

    public void clickMoneyTransferButton() {
        openMoneyTransferButton.click();
    }

    public void transferMoneyButton() {
        transferMoneyButton.click();
    }

    public void sendAmountTransfer(String amount) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement amountprice = driver.findElement(By.xpath("//input[@inputmode='numeric']"));
        amountPrice.click();
        amountprice.sendKeys(amount);
        //amountPrice.sendKeys("amount");
    }

    public void sendButton() {
        sendButton.click();
    }
    public void check0moneyTransfer(String amount) throws InterruptedException {
        // Butonun etkin olup olmadığını kontrol et
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement hesapBakiyesi = driver.findElement(By.xpath("(//div[@dir='auto'])[16]"));
        String bakiye= hesapBakiyesi.getText();
        System.out.println(bakiye);

        WebElement transferButton = driver.findElement(By.xpath("//div[text()='Transfer money']"));
        transferButton.click();

        WebElement amountprice = driver.findElement(By.xpath("//input[@inputmode='numeric']"));
        amountPrice.click();
        amountprice.sendKeys(amount);

        WebElement sendButton1 = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton1.click();

        WebDriverWait wait = new WebDriverWait(driver,(30000));
        WebElement transferButton1 = driver.findElement(By.xpath("//div[text()='Transfer money']"));
        transferButton1.click();
        WebElement xButton= driver.findElement(By.xpath("//div[text()='\uE633']"));
        xButton.click();

        WebElement hesapBakiyesi1 = driver.findElement(By.xpath("(//div[@dir='auto'])[16]"));
        String bakiye1= hesapBakiyesi1.getText();
        System.out.println(bakiye1);


        if (bakiye1.equals(bakiye)) {
            System.out.println("Para gönderimi yapılmadı");
        } else {

            System.out.println("Para transferi gerçekleşti.");
        }

    }

    public void transferAmountCheck() {
        transferAmount.isDisplayed();
    }
    public void clickAddMoneyButton() {
        addMoneyButton.click();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void cardNumber(String KartNo) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cardNumber = driver.findElement(By.xpath("//input[@inputmode='numeric']"));
        cardNumber.sendKeys(KartNo);
    }

    public void requiredisDisplayed() {
        requiredWarning.isDisplayed();
    }
    public void cardHolder(String Kartismi ) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cardHolder = driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[2]"));
        cardHolder.sendKeys(Kartismi);
    }

    public void expireDate(String sonKullanmaTarihi ) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement expireDate = driver.findElement(By.xpath("(//input[@inputmode='numeric'])[2]"));
        expireDate.sendKeys(sonKullanmaTarihi);
    }

    public void cvvNo(String Cvv) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cvv = driver.findElement(By.xpath("(//input[@inputmode='numeric'])[3]"));
        cvv.sendKeys(Cvv);
    }

    public void amount(String miktar) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement amount = driver.findElement(By.xpath("(//input[@inputmode='numeric'])[4]"));
        amount.sendKeys(miktar);
    }

    public void checkAmount() {
        WebElement amountCheck = driver.findElement(By.xpath("//div[text()='100.00']"));
        amountCheck.isDisplayed();
    }

    public void editAccountPage() {
        WebElement editAccount = driver.findElement(By.xpath("//div[text()='Edit account']"));
        editAccount.click();

        WebElement accountName = driver.findElement(By.xpath("//input[@autocapitalize='sentences']"));
        WebElement updateButton = driver.findElement(By.xpath("//div[text()='UPDATE']"));

        accountName.clear();
        accountName.sendKeys("Test_Checking1");
        updateButton.click();

        WebElement checkAccountName1 = driver.findElement(By.xpath("//div[text()='Test_Checking1']"));
        checkAccountName1.isDisplayed();
        editAccount.click();

        WebElement accountName1 = driver.findElement(By.xpath("//input[@autocapitalize='sentences']"));
        accountName1.clear();
        accountName1.sendKeys("Test_Checking");
        WebElement updateButton1 = driver.findElement(By.xpath("//div[text()='UPDATE']"));
        updateButton1.click();
        WebElement checkAccountName = driver.findElement(By.xpath("//div[text()='Test_Checking']"));
        checkAccountName.isDisplayed();
    }
    public void add0moneyTransfer(String amountOfMoney ){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement hesapBakiyesi = driver.findElement(By.xpath("(//div[@dir='auto'])[16]"));
        String bakiye= hesapBakiyesi.getText();
        System.out.println(bakiye);

        WebElement addMoneyButton = driver.findElement(By.xpath("//div[text()='Add money']"));
        addMoneyButton.click();

        WebElement cardNumber = driver.findElement(By.xpath("//input[@inputmode='numeric']"));
        cardNumber.sendKeys("1234123412341234");

        WebElement cardHolder = driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[2]"));
        cardHolder.sendKeys("Otomasyon test");

        WebElement expireDate = driver.findElement(By.xpath("(//input[@inputmode='numeric'])[2]"));
        expireDate.sendKeys("1025");

        WebElement cvv = driver.findElement(By.xpath("(//input[@inputmode='numeric'])[3]"));
        cvv.sendKeys("110");

        WebElement amount = driver.findElement(By.xpath("(//input[@inputmode='numeric'])[4]"));
        amount.sendKeys(amountOfMoney);

        WebElement buttonAdd = driver.findElement(By.xpath("//div[text()='Add']"));
        buttonAdd.click();

        WebElement transferButton1 = driver.findElement(By.xpath("//div[text()='Transfer money']"));
        transferButton1.click();
        WebElement xButton= driver.findElement(By.xpath("//div[text()='\uE633']"));
        xButton.click();

        WebElement hesapBakiyesi1 = driver.findElement(By.xpath("(//div[@dir='auto'])[16]"));
        String bakiye1= hesapBakiyesi1.getText();
        System.out.println(bakiye1);


        if (bakiye1.equals(bakiye)) {
            System.out.println("Para gönderimi yapılmadı");
        } else {

            System.out.println("Para transferi gerçekleşti.");
        }



    }




    public void negatifAmountMoneyCheck() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement hesapBakiyesi = driver.findElement(By.xpath("(//div[@dir='auto'])[16]"));
        String bakiye= hesapBakiyesi.getText();
        System.out.println(bakiye);

        WebElement transferButton = driver.findElement(By.xpath("//div[text()='Transfer money']"));
        transferButton.click();

        WebElement amountprice = driver.findElement(By.xpath("//input[@inputmode='numeric']"));
        amountPrice.click();
        amountprice.sendKeys(bakiye);

        WebElement sendButton1 = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton1.click();

        WebDriverWait wait = new WebDriverWait(driver,(30000));
        WebElement transferButton1 = driver.findElement(By.xpath("//div[text()='Transfer money']"));
        transferButton1.click();
        WebElement xButton= driver.findElement(By.xpath("//div[text()='\uE633']"));
        xButton.click();

        WebElement hesapBakiyesi1 = driver.findElement(By.xpath("(//div[@dir='auto'])[16]"));
        String bakiye1= hesapBakiyesi1.getText();
        System.out.println(bakiye1);


        if (bakiye1.equals(bakiye)) {
            System.out.println("Para gönderimi yapılmadı");
        } else {

            System.out.println("Para transferi gerçekleşti.");
        }


    }





    }



