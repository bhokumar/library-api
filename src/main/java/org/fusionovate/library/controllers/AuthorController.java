package org.fusionovate.library.controllers;

import org.fusionovate.library.models.Author;
import org.fusionovate.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author addedAuthor = authorService.addAuthor(author);
        return ResponseEntity.ok(addedAuthor);
    }
}
