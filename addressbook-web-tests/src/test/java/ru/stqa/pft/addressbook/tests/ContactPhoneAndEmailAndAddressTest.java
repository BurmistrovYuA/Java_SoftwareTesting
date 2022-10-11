package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactPhoneAndEmailAndAddressTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    ContactData contact = new ContactData()
            .withFirstname("test1").withLastname("Burmistrov").withAddress("Rnd")
            .withHomePhone("89999999999").withMobilePhone("+822222222")
            .withWorkPhone("833333333").withEmail("Burmistrov@yandex.ru")
            .withEmail2("Burmistrof@yandex.ru").withEmail3("Burmistro@yandex.ru").withGroup("test1");
    if (app.contact().all().size() == 0) {
      app.contact().create(contact);
    }
  }

  @Test
  public void testContactPhonesAndEmailsAndAddress() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), CoreMatchers.equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.getAddress(), CoreMatchers.equalTo(contactInfoFromEditForm.getAddress()));
  }


  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneAndEmailAndAddressTest::cleanedPhones)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneAndEmailAndAddressTest::cleanedEmails)
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedPhones(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]]", "");
  }

  public static String cleanedEmails(String email) {
    return email.replaceAll("\\s", "");
  }

}
