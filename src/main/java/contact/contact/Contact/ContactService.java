package contact.contact.Contact;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService  {
        // این خط برای یکبار مقدار دهی است
    private final ContactRepositor contactRepositor;

    public ContactService(ContactRepositor contactRepositor) {
        this.contactRepositor = contactRepositor;
    }
         //  ذخیره  مخاطب
    public ContactEntity saveContact(ContactEntity contact) {
        return contactRepositor.save(contact);
    }
    //حذف مخاطب
    public void deleteContact(Long id) {
        contactRepositor.deleteById(id);
    }
    //لیست مخاطب
    public List<ContactEntity> getAllContacts() {
        return contactRepositor.findAll();
    }
     //  دریافت مخاطب با ID
    public Optional<ContactEntity> getContactById(Long id) {
        return contactRepositor.findById(id);
        }
        //دریافت مخاطب با نام
    public Optional<ContactEntity> getContactByName(String name) {
        return contactRepositor.findByName(name);
    }
    //دریافت مخاطب با نام خانوادگی
    public Optional<ContactEntity> getContactByLastname(String lastname) {
        return contactRepositor.findByLastName(lastname);
    }
    //دریافت مخاطب براساس موبایل
    public Optional<ContactEntity> getContactByMobile(String mobile) {
        return contactRepositor.findByMobile(mobile);
    }
    //آپدیت مخاطب
    public ContactEntity updateContact(Long id, ContactEntity updatedContact) {
        return contactRepositor.findById(id)
                .map(existing -> {
                    existing.setName(updatedContact.getName());
                    existing.setMobile(updatedContact.getMobile());
                    existing.setEmail(updatedContact.getEmail());
                    return contactRepositor.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Contact not found"));
    }
}
