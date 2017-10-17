package ru.alvisid.notemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.alvisid.notemanager.model.Note;
import ru.alvisid.notemanager.service.NoteService;

@Controller
public class NoteController {
    private NoteService noteService;

    @Autowired(required = true)
    @Qualifier(value = "noteService")
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "notes", method = RequestMethod.GET)
    public String listNotes(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("listNotes", noteService.listNotes());
        model.addAttribute("currentpage", noteService.getCurrentPage() + 1);
        model.addAttribute("amountpages", noteService.amountPages());

        return "notes";
    }

    @RequestMapping(value = "/notes/add", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("note") Note note){
        System.out.println("add...." + note.getId());
        if (note.getId() == 0) {
            noteService.addNote(note);
        } else {
            noteService.updateNote(note);
        }

        return "redirect:/notes";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeNote(@PathVariable("id")int id) {
        noteService.removeNote(id);

        return "redirect:/notes";
    }

    @RequestMapping(value = "edit/{id}")
    public String editNote(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", noteService.getNoteById(id));
        model.addAttribute("listNotes", noteService.listNotes());
        model.addAttribute("currentpage", noteService.getCurrentPage() + 1);
        model.addAttribute("amountpages", noteService.amountPages());

        return "notes";
    }

    @RequestMapping(value = "/notes/moveleft")
    public String moveLeft() {
        noteService.moveLeft();

        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/moveright")
    public String moveRight() {
        noteService.moveRight();

        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/movefirst")
    public String moveFirst() {
        noteService.moveFirst();

        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/movelast")
    public String moveLast() {
        noteService.moveLast();

        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/showallnotes")
    public String showAllNotes() {
        noteService.showAllNotes();

        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/showperformed")
    public String showPerformed() {
        noteService.showPerformed();

        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/showunperformed")
    public String showUnperformed() {
        noteService.showUnperformed();

        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/sortdate")
    public String sortDate() {
        noteService.sortDate();

        return "redirect:/notes";
    }
}
