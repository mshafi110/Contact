package contact.contact.Contact;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Contacts")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //برای اجباری کردن ستون ها
    @Column(nullable = false)
    private  String name;
    private String lastName;
    private String mobile;
    private String email;

//ساخت constructor
  /*  public ContactEntity() {

    }
     public ContactEntity(String name, String lastName, String mobile, String email) {
        this.name = name;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
     }*/
    // با استفاده از @data متد های getter , setter ساخته می شود
    //نمایش دادن اطلاعات
 /*  public void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Mobile: " + this.mobile);
        System.out.println("Email: " + this.email);
   }*/

    @Override
    public String toString() {
        return "Name: " + this.name + ", Last Name: " + this.lastName + ", Mobile: " + this.mobile + ", Email: " + this.email;

    }
}
