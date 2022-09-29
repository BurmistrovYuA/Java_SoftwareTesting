package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;;
  private String name;
  private String last_name;
  private String address;
  private String phones;
  private String email;
  private String group;

  public int getId() { return id; }
  public String getName() { return name; }

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

  public String getGroup() { return group; }


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }
  public ContactData withLast_name(String last_name) {
    this.last_name = last_name;
    return this;
  }
  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
  public ContactData withPhones(String phones) {
    this.phones = phones;
    return this;
  }
  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) && Objects.equals(last_name, that.last_name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(name, last_name);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", last_name='" + last_name + '\'' +
            '}';
  }
}
