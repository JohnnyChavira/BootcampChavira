package org.example;

import java.util.Scanner;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private boolean IsCheckedOut;
    private String CheckedOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedOut,
                String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        IsCheckedOut = isCheckedOut;
        CheckedOutTo = checkedOutTo;
    }

    public Book(int id, String isbn, String title, boolean isCheckedOut) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        IsCheckedOut = isCheckedOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return IsCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        IsCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return CheckedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        CheckedOutTo = checkedOutTo;
    }

    public void checkIn(){
        this.IsCheckedOut = false;
    }

    public void checkOut(){
        this.IsCheckedOut = true;
    }
}

