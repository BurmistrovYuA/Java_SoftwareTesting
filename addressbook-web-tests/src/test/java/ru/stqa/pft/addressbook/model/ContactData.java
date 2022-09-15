package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String last_name;
  private final String address;
  private final String phones;
  private final String email;
  private String group;

  public ContactData(String name, String last_name, String address, String phones, String email, String group) {
    this.name = name;
    this.last_name = last_name;
    this.address = address;
    this.phones = phones;
    this.email = email;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getLast_name() {
    return last_name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhones() {
    return phones;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
