package com.panthole.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "simple_book")
@XmlRootElement
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int NAME_LENGTH = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EMP_SEQ")
    @SequenceGenerator(name = "EMP_SEQ")
    @Column(unique = true, nullable = false, name = "BOOKID")
    @XmlAttribute(name = "bookId")
    private Long bookId;
    
    @Column(length = Book.NAME_LENGTH, name = "BOOKNAME")
    @XmlAttribute(name = "bookName")
    private String bookName;
    
    @Column(length = Book.NAME_LENGTH, name = "PUBLISHER")
    @XmlAttribute(name = "publisher")
    private String publisher;

    public Book() {
        super();
    }

    public Book(final Long bookId) {
        this.bookId = bookId;
    }

    public Book(final String bookName) {
        this.bookName = bookName;
    }

    public Book(final Long bookId, final String bookName) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public Book(final Long bookId, final String bookName, String publisher) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publisher = publisher;
    }


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(final Long bookId) {
        this.bookId = bookId;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(final String bookName) {
        this.bookName = bookName;
    }


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return bookId + ":" + bookName + ":" + publisher;
    }
}
