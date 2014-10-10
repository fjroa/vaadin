package es.indra.hlf.vaadin.isfar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.indra.hlf.vaadin.isfar.model.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long> {

}
