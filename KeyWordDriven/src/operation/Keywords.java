package operation;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Keywords {
WebDriver driver;
public Keywords(WebDriver driver){
this.driver = driver;
}
public void perform(Properties p,String operation,String objectName,String
objectType,String value) throws Exception{
System.out.println("");
if(operation.equals("CLICK"))
{
try
{
driver.findElement(this.getObject(p,objectName,objectType)).click();
}
catch(Exception e)
{
System.out.println(e);
}
}
else if(operation.equals("ENTERDATA"))
{

try
{
driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
}
catch(Exception e)
{
System.out.println(e);
}
}
else if(operation.equals("OPENAPPLICATION"))
{
try
{
driver.get(p.getProperty(value));
}
catch(Exception e)
{
System.out.println(e);
}
}
else if(operation.equals("CLOSEAPPLICATION"))
{
try
{
driver.quit();
}
catch(Exception e)
{
System.out.println(e);
}
}
else if(operation.equals("GETTEXT"))
{
try
{
driver.findElement(this.getObject(p,objectName,objectType)).getText();
}
catch(Exception e)
{
System.out.println(e);
}
}
else
{

System.out.println("Keyword not fount");
}
}
/**
* Find element BY using object type and value
* @para
m p
* @param objectName
* @param objectType
* @return
* @throws Exception
*/
private By getObject(Properties p,String objectName,String objectType) throws
Exception{
//Find by xpath
if(objectType.equalsIgnoreCase("XPATH")){
return By.
xpath(p.getProperty(objectName));
}
//find by class
else if(objectType.equalsIgnoreCase("CLASSNAME")){
return By.className(p.getProperty(objectName));
}
//find by name
else if(objectType.equalsIgnoreCase("NAME")){
return By.name(p.getProperty(objectName));
}
//Find by css
else if(objectType.equalsIgnoreCase("CSS")){
return By.cssSelector(p.getProperty(objectName));
}
//find by link
else if(objectType.equalsIgnoreCase("LINK")){
return By.linkText(p.getProperty(objectName));
}
//find by partial link
else if(objectType.equalsIgnoreCase("PARTIALLINK")){

return By.partialLinkText(p.getProperty(objectName));
}else
{
throw new Exception("Wrong object type");
}
}
}