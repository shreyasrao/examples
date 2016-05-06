package pset6;

import static org.junit.Assert.*;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.*;
public class MinWebTestSuite {
public static WebDriver wd = new FirefoxDriver();
@BeforeClass public static void setup(){
wd.get("file://C:/Users/shreyas/Desktop/min.html");
}
@Test public void t0() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t1() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t2() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t3() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t4() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t5() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t6() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t7() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t8() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t9() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t10() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t11() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t12() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t13() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t14() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t15() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t16() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t17() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t18() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t19() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t20() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t21() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t22() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t23() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t24() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t25() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t26() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t27() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t28() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t29() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t30() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t31() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t32() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t33() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t34() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t35() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t36() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t37() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t38() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t39() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t40() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t41() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t42() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t43() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t44() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t45() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t46() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t47() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t48() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t49() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t50() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t51() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t52() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t53() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t54() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t55() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t56() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t57() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t58() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t59() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t60() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t61() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t62() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t63() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("", output);
}
@Test public void t64() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t65() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t66() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t67() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t68() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t69() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t70() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t71() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t72() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t73() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t74() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t75() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t76() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t77() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t78() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t79() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("four");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t80() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t81() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t82() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t83() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t84() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t85() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(-1, -1, -1) = -1", output);
}
@Test public void t86() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(-1, -1, 0) = -1", output);
}
@Test public void t87() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(-1, -1, 1) = -1", output);
}
@Test public void t88() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t89() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(-1, 0, -1) = -1", output);
}
@Test public void t90() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(-1, 0, 0) = -1", output);
}
@Test public void t91() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(-1, 0, 1) = -1", output);
}
@Test public void t92() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t93() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(-1, 1, -1) = -1", output);
}
@Test public void t94() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(-1, 1, 0) = -1", output);
}
@Test public void t95() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("-1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(-1, 1, 1) = -1", output);
}
@Test public void t96() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t97() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t98() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t99() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t100() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t101() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(0, -1, -1) = -1", output);
}
@Test public void t102() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(0, -1, 0) = -1", output);
}
@Test public void t103() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(0, -1, 1) = -1", output);
}
@Test public void t104() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t105() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(0, 0, -1) = -1", output);
}
@Test public void t106() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(0, 0, 0) = 0", output);
}
@Test public void t107() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(0, 0, 1) = 0", output);
}
@Test public void t108() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t109() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(0, 1, -1) = -1", output);
}
@Test public void t110() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(0, 1, 0) = 0", output);
}
@Test public void t111() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("0");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(0, 1, 1) = 0", output);
}
@Test public void t112() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t113() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t114() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t115() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("four");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t116() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t117() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(1, -1, -1) = -1", output);
}
@Test public void t118() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(1, -1, 0) = -1", output);
}
@Test public void t119() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("-1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(1, -1, 1) = -1", output);
}
@Test public void t120() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t121() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(1, 0, -1) = -1", output);
}
@Test public void t122() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(1, 0, 0) = 0", output);
}
@Test public void t123() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("0");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(1, 0, 1) = 0", output);
}
@Test public void t124() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("four");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("Please enter integer values only!", output);
}
@Test public void t125() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("-1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(1, 1, -1) = -1", output);
}
@Test public void t126() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("0");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(1, 1, 0) = 0", output);
}
@Test public void t127() {
wd.navigate().refresh();
WebElement we = wd.findElement(By.id("x"));
we.sendKeys("1");
we = wd.findElement(By.id("y"));
we.sendKeys("1");
we = wd.findElement(By.id("z"));
we.sendKeys("1");
we = wd.findElement(By.id("computeButton"));
we.click();
WebElement result = wd.findElement(By.id("result"));
String output = result.getText();
assertEquals("min(1, 1, 1) = 1", output);
}
@AfterClass public static void close(){
wd.quit();}
}

