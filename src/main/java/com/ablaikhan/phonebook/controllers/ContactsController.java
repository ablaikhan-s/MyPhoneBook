package com.ablaikhan.phonebook.controllers;

import com.ablaikhan.phonebook.dao.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phonebook")
public class ContactsController {
    private final ContactDAO contactDAO;

    @Autowired
    public ContactsController(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("contacts", contactDAO.index());
        return "index";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam(value = "filter", required = true) String text, Model model){
        model.addAttribute("contacts", contactDAO.filter(text));
        return "index";
    }

    @PostMapping("newcontact")
    public String newcontactform(){
        return "newcontact";
    }

    @PostMapping("createcontact")
    public String createcontact( @RequestParam(value = "Firstname") String fname,
                               @RequestParam(value = "Lastname") String lname,
                               @RequestParam(value = "P_number") String pnumber,
                               @RequestParam(value = "Adress") String adress, Model model){
        contactDAO.createcontact(fname, lname, pnumber, adress);
        model.addAttribute("contacts", contactDAO.index());
        return "index";
    }
/*    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("contact", contactDAO.show(id));
        return "people/show";
    }*/

 /*   @GetMapping("/new")
    public String newContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "people/new";
    }*/

/*
    @PostMapping()
    public String create(@ModelAttribute("contact") Contact contact){
        contactDAO.save(contact);
        return "redirect:/people";
    }
*/
}