package com.vmware.ensemble.rules.i18n.engine;

import com.vmware.ensemble.rules.i18n.model.Document;

import java.util.Set;

public interface SearchEngine {
    void add(Document document);
    Set<Integer> search(String text);
}
