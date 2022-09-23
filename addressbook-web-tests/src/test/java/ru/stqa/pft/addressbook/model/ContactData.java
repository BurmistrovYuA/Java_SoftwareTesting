package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String name;
  private final String last_name;
  private final String address;
  private final String phones;
  private final String email;
  private String group;

  public ContactData(int id, String name, String last_name, String address, String phones, String email, String group) {
    this.id = id;
    this.name = name;
    this.last_name = last_name;
    this.address = address;
    this.phones = phones;
    this.email = email;
    this.group = group;
  }
  public ContactData(String name, String last_name, String address, String phones, String email, String group) {
    this.id = 0;
    this.name = name;
    this.last_name = last_name;
    this.address = address;
    this.phones = phones;
    this.email = email;
    this.group = group;
  }

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

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactsData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", last_name='" + last_name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (!Objects.equals(name, that.name)) return false;
    return Objects.equals(last_name, that.last_name);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
    return result;
  }

}
