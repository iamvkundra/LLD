package com.vmware.ensemble.rules.i18n.model;

import javax.print.Doc;

public class Document {

    public int documentId;
    public String text;

    public Document(int documentId, String text) {
        this.text = text;
        this.documentId = documentId;
    }
}
