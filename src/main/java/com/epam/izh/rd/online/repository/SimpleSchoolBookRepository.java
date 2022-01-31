package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    private SchoolBook[] schoolBooks = new SchoolBook[0];

    @Override
    public boolean save(SchoolBook book) {
        schoolBooks = Arrays.copyOf(schoolBooks, schoolBooks.length + 1);
        schoolBooks[schoolBooks.length - 1] = book;

        return schoolBooks[schoolBooks.length - 1] == book;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] findedBooks = new SchoolBook[0];

        for(SchoolBook book: schoolBooks) {
            if(book.getName() == name) {
                findedBooks = Arrays.copyOf(findedBooks, findedBooks.length + 1);
                findedBooks[findedBooks.length - 1] = book;
            }
        }

        return findedBooks;
    }

    @Override
    public boolean removeByName(String name) {
        int count = 0;

        for(SchoolBook book: schoolBooks) {
            if(book.getName() == name) {
                book = null;
                count++;
            }
        }

        if(count == 0) return false;

        SchoolBook[] removeBook = new SchoolBook[schoolBooks.length - count];

        count = 0;

        for(SchoolBook book: schoolBooks) {
            if(book != null) {
                removeBook[count++] = book;
            }
        }

        schoolBooks = removeBook;

        return true;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
