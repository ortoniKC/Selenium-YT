package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LetsDoTheSort {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://letcode.in/advanced-web-tables");

        int rowSize = 7;
        ArrayList<TableData> list = new ArrayList<>();
        for (int i = 2; i < rowSize; i++) {
            WebElement fat = driver.findElementByXPath("//table[@class='mat-sort']/tr[" + i + "]/td[3]");
            WebElement dessert = driver.findElementByXPath("//table[@class='mat-sort']/tr[" + i + "]/td[1]");

            int fatValue = Integer.parseInt(fat.getText());
            list.add(new TableData(fatValue, dessert.getText()));

            // System.out.println(fat.getText());
            // System.out.println(dessert.getText());
        }
        System.out.println("before sorting " + list);
        Collections.sort(list);
        System.out.println("After sorting " + list);
        list.forEach(i -> {
            System.out.println("Fat: " + i.fat + "dessert: " + i.dessert);
        });

        driver.quit();

    }
}

class TableData implements Comparable<TableData> {

    Integer fat;
    String dessert;

    public TableData(Integer fat, String dessert) {
        this.fat = fat;
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        return "TableData [dessert=" + dessert + ", fat=" + fat + "]";
    }

    @Override
    public int compareTo(TableData data) {
        if (this.fat < data.fat) {
            return -1;
        } else
            return 0;

    }

}