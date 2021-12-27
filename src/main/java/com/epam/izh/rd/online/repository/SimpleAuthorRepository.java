package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[0];

    @Override
    public boolean save(Author author) {
        if(findByFullName(author.getName(), author.getLastName()) == null) {
            authors = Arrays.copyOf(authors, authors.length + 1);
            authors[authors.length - 1] = author;

            return true;
        }

        return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for(Author author: authors) {
            if(name == author.getName() && lastname == author.getLastName()) {
                return author;
            }
        }

        return null;
    }

    @Override
    public boolean remove(Author author) {
        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
