package contact.contact.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepositor extends JpaRepository <ContactEntity,Long> {

    Optional<ContactEntity> findByMobile(String mobile);//جستجو براساس شماره موبایل

    Optional<ContactEntity> findByName(String name);

    Optional<ContactEntity> findByLastName(String lastName);
}
