package com.vmware.ensemble.rules.i18n.model;

import com.vmware.ensemble.rules.i18n.enums.Language;

public class Book {

    private String title;
    private String subject;
    private String publisher;
    private Language language;
    private int numberOfPages;

    public Book(String title, String subject, String publisher, Language language, int numberOfPages) {
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }




}
