package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(ContactData.class);
      xStream.allowTypes(new Class[]{ContactData.class});
      List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testNewContact(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    app.contact().create(contact);
    app.goTo().homePage();
    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    verifyContactListInUI();
  }

  @Test(enabled = false)
  public void testBadNewContact() throws Exception {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData contact = new ContactData()
            .withFirstname("test1'").withLastname("Burmistrov").withAddress("rnd")
            .withHomePhone("89999999999").withMobilePhone("822222222")
            .withWorkPhone("833333333").withEmail("asd@yyy.ru");
    app.contact().create(contact);
    app.goTo().homePage();
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
    verifyContactListInUI();
  }
/*
* @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testNewContact(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    //File photo = new File("src/test/resources/photo.jpg");
   // ContactData contact = new ContactData()
  //          .withFirstname("test1").withLastname("Burmistrov").withAddress("rnd")
   //         .withHomePhone("89999999999").withMobilePhone("822222222")
   //         .withWorkPhone("833333333").withEmail("asd@yyy.ru").withPhoto(photo);*/
   /* app.contact().create(contact);
    app.goTo().homePage();
  assertEquals(app.contact().count(), before.size() + 1);
  Contacts after = app.contact().all();
  assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
}

  @Test(enabled = false)
  public void testBadNewContact() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("test1'").withLastname("Burmistrov").withAddress("rnd")
            .withHomePhone("89999999999").withMobilePhone("822222222")
            .withWorkPhone("833333333").withEmail("asd@yyy.ru");
    app.contact().create(contact);
    app.goTo().homePage();
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }*/
}