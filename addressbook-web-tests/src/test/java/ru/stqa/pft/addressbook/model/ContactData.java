package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;;
  private String name;
  private String middlename;
  private String last_name;
  private String nickname;
  private String address;
  private String company;
  private String allPhones;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String email;
  private String email2;
  private String email3;
  private String group;
  private String allEmails;
  private File photo;

  public File getPhoto() { return photo; }
  public String getAllEmails() { return allEmails;}
  public int getId() { return id; }
  public String getName() { return name; }
  public String getMiddlename() {
    return middlename;
  }
  public String getLast_name() {
    return last_name;
  }
  public String getNickname() { return nickname; }
  public String getCompany() { return company; }
  public String getAddress() { return address; }
  public String getHomePhone() {
    return homePhone;
  }
  public String getMobilePhone() {
    return mobilePhone;
  }
  public String getWorkPhone() {
    return workPhone;
  }
  public String getAllPhones() { return allPhones; }
  public String getEmail() { return email; }
  public String getEmail2() { return email2; }
  public String getEmail3() { return email3; }

  public String getGroup() { return group; }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }
  public ContactData withFirstname(String name) {
    this.name = name;
    return this;
  }
  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }
  public ContactData withLastname(String last_name) {
    this.last_name = last_name;
    return this;
  }
  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;

  }  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }
  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  public ContactData withHomePhone(String phones) {
    this.homePhone = phones;
    return this;
  }
  public ContactData withMobilePhone(String phones2) {
    this.mobilePhone = phones2;
    return this;
  }
  public ContactData withWorkPhone(String phones3) {
    this.workPhone = phones3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
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

    if (id != that.id) return false;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
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
