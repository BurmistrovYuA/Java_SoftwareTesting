        package ru.stqa.pft.addressbook.tests;

        import org.openqa.selenium.remote.BrowserType;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.AfterSuite;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.BeforeSuite;
        import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
        import ru.stqa.pft.addressbook.model.ContactData;
        import ru.stqa.pft.addressbook.model.Contacts;
        import ru.stqa.pft.addressbook.model.GroupData;
        import ru.stqa.pft.addressbook.model.Groups;

        import java.io.IOException;
        import java.lang.reflect.Method;
        import java.util.Arrays;
        import java.util.stream.Collectors;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.Matchers.equalTo;

        public class TestBase {

          protected static ApplicationManager app;
          Logger logger = (Logger) LoggerFactory.getLogger(TestBase.class);
          static {
            try {
              app = new
                      ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
            } catch (IOException e) {
              e.printStackTrace();
            }
          }

          @BeforeSuite
          public void setUp() throws Exception {
            app.init();
          }

          @AfterSuite
          public void tearDown() throws Exception {
            app.stop();
          }

          public ApplicationManager getApp() {
            return app;
          }

          @BeforeMethod
          public void logTestStart(Method m, Object[] p) {
            logger.info("Start test " + m.getName() + " with parameters" + Arrays.asList(p));
          }

          @AfterMethod(alwaysRun = true)
          public void logTestStop(Method m) {
            logger.info("Stop test " + m.getName());
          }

          public void verifyGroupListInUI() {//-DverifyUI=true
            if (Boolean.getBoolean("verifyUI")){
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream().map((g)-> new GroupData()
                    .withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
            }
          }

          public void verifyContactListInUI() {//-DverifyUI=true
            if (Boolean.getBoolean("verifyUI")){
              Contacts dbContacts = app.db().contacts();
              Contacts uiContacts = app.contact().all();
              assertThat(uiContacts, equalTo(dbContacts.stream().map((g)-> new ContactData()
                      .withId(g.getId()).withFirstname(g.getFirstname()))
                      .collect(Collectors.toSet())));
            }
          }
        }