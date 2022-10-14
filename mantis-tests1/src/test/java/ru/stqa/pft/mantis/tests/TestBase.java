package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
<<<<<<< HEAD
    app.ftp().upload(new File("src/test/resources/config_inc.php")
            , "config_inc.php", "config_inc.php.bak");

=======
>>>>>>> parent of 7eb05cf (Лекция 8.5. Передача файлов на удалённую машину по протоколу FTP)
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
<<<<<<< HEAD
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
=======
>>>>>>> parent of 7eb05cf (Лекция 8.5. Передача файлов на удалённую машину по протоколу FTP)
    app.stop();
  }
}