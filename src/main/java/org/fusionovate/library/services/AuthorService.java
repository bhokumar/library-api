package org.fusionovate.library.services;

import org.fusionovate.library.dao.AuthorRepository;
import org.fusionovate.library.models.Author;
import org.fusionovate.library.validators.AuthorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorValidator authorValidator;

    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(Author author) {
        if (!authorValidator.isAuthorValid(author)) {
            throw new IllegalArgumentException("Author is not valid");
        }
        return authorRepository.addAuthor(author);
    }
}
