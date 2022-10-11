package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table( name = "addressbook")
public class ContactData {
  @Id
  @Column(name = "id")
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private String firstname;
  @Expose
  @Column(name = "middlename")//
  private String middlename;
  @Expose
  @Column(name = "lastname")
  private String lastname;
  @Expose
  @Column(name = "nickname")
  private String nickname;
  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;
  @Expose
  @Column(name = "company")
  private String company;
  @Transient
  private String allPhones;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;
  @Expose
  @Type(type = "text")
  @Column(name = "email2")
  private String email2;
  @Expose
  @Type(type = "text")
  @Column(name = "email3")
  private String email3;
  @Transient
  private String group;
  @Transient
  private String allEmails;
  @Transient
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public String getAllEmails() {
    return allEmails;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getGroup() {
    return group;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;

  }

  public ContactData withCompany(String company) {
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

    if (!Objects.equals(firstname, that.firstname)) return false;
    if (!Objects.equals(middlename, that.middlename)) return false;
    if (!Objects.equals(lastname, that.lastname)) return false;
    if (!Objects.equals(nickname, that.nickname)) return false;
    if (!Objects.equals(address, that.address)) return false;
    if (!Objects.equals(company, that.company)) return false;
    if (!Objects.equals(homePhone, that.homePhone)) return false;
    if (!Objects.equals(mobilePhone, that.mobilePhone)) return false;
    if (!Objects.equals(workPhone, that.workPhone)) return false;
    if (!Objects.equals(email, that.email)) return false;
    if (!Objects.equals(email2, that.email2)) return false;
    return Objects.equals(email3, that.email3);
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
    result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
    result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    return result;
  }


  @Override
  public String toString() {
    return "ContactsData{" + "id=" + id + ", firstname='" + firstname + '\'' + ", middlename='" + middlename + '\'' + ", lastname='" + lastname + '\'' + ", nickname='" + nickname + '\'' + ", address='" + address + '\'' + ", company='" + company + '\'' + ", email='" + email + '\'' + ", email2='" + email2 + '\'' + ", email3='" + email3 + '\'' + ", homePhone='" + homePhone + '\'' + ", mobilePhone='" + mobilePhone + '\'' + ", workPhone='" + workPhone + '\'' + '}';
  }

}
