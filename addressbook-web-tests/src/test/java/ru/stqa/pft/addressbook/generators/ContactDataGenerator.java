package ru.stqa.pft.addressbook.generators;
//-c 2 -f src/test/resources/contacts.json -d json
//C:\Users\car2f\Documents\GitHub\Java_SoftwareTesting\addressbook-web-tests
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class ContactDataGenerator {
  @Parameter(names = "-c",  description="Contact count")
  public int count;
  @Parameter(names = "-f",  description="Target file")
  public String file;
  @Parameter(names = "-d",  description="Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander JCommander = new JCommander(generator);
    try {
      JCommander.parse(args);
    } catch (ParameterException ex) {
      JCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContact(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")){
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognize format" + format);
    }
  }
  private  void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try(Writer writer = new FileWriter(file)){
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try(Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(),
                contact.getMiddlename(), contact.getLastname(), contact.getNickname(),
                contact.getCompany(), contact.getAddress(), contact.getHomePhone(),
                contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmail(),
                contact.getEmail2(), contact.getEmail3()));
      }
    }
  }
  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson= new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json= gson.toJson(contacts);
    try(Writer writer =new FileWriter(file)){
    writer.write(json);
    }
  }

  private List<ContactData> generateContact(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++){
      contacts.add(new ContactData().
              withFirstname(String.format("Name %s", i)).withMiddlename(String.format("Middlename %s", i)).
              withLastname(String.format("Last_name %s", i)).withNickname(String.format("Nickname %s", i)).
              withCompany(String.format("Company %s", i)).withAddress(String.format("Address %s", i)).
              withHomePhone(String.format("8928552251%s", i)).withMobilePhone(String.format("8928552252%s", i)).
              withWorkPhone(String.format("8928552253%s", i)).withEmail(String.format("Email%s" + "@ya.ru", i)).
              withEmail2(String.format("Email2%s" + "@ya.ru", i)).withEmail3(String.format("Email3%s" + "@ya.ru", i)));
    }
    return contacts;
  }
}

