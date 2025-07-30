package contact.contact.Contact;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    //  افزودن یا ویرایش مخاطب
    @PostMapping
    public ContactEntity saveContact(@RequestBody ContactEntity contact) {
        return contactService.saveContact(contact);
    }

    //  دریافت همه مخاطبین
    @GetMapping
    public List<ContactEntity> getAllContacts() {
        return contactService.getAllContacts();
    }

    //  دریافت مخاطب با ID
    @GetMapping("/{id}")
    public Optional<ContactEntity> getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    //  دریافت مخاطب با نام
    @GetMapping("/{name}")
    public Optional<ContactEntity> getContactByname(@PathVariable String name) {
        return contactService.getContactByName(name);
    }

    //  دریافت مخاطب با نام خانوادگی
    @GetMapping("/{Lastname}")
    public Optional<ContactEntity> getContactByLastname(@PathVariable String Lastname) {
        return contactService.getContactByLastname(Lastname);
    }

    //  دریافت مخاطب با مویابل
    //@RequestParam ~ @PathVariable
    @GetMapping("/{Mobile}")
    public Optional<ContactEntity> getContactBymobile(@PathVariable String Mobile) {
        return contactService.getContactByMobile(Mobile);
    }

    // 🗑 حذف مخاطب با ID
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    //  به‌روزرسانی مخاطب با ID
    @PutMapping("/{id}")
    public ContactEntity updateContact(@PathVariable Long id, @RequestBody ContactEntity updatedContact) {
        return contactService.updateContact(id, updatedContact);
    }


}
