package com.wonbeomjang.bookselling.DataUtils.Book;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByID {
    public static void sort(ArrayList<Book> books) {
        books.sort(Comparator.comparingInt(book -> Integer.parseInt(book.getId())));
    }
}

