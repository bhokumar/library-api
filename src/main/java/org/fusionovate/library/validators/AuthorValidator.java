package org.fusionovate.library.validators;

import org.fusionovate.library.models.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorValidator {

    public boolean isAuthorValid(Author author) {
        return author.getName() != null && author.getEmail() != null && author.getDob() != null;
    }
}
