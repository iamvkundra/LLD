package com.vmware.ensemble.rules.i18n;

import com.vmware.ensemble.rules.i18n.engine.SearchEngine;
import com.vmware.ensemble.rules.i18n.engine.impl.TrieEngine;
import com.vmware.ensemble.rules.i18n.model.Document;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SearchEngine searchEngine = new TrieEngine();
        searchEngine.add(new Document(1, "This is a demo log"));
        searchEngine.add(new Document(2, "This is a demo log line"));
        searchEngine.add(new Document(3,"This is not a log line"));

        System.out.println(searchEngine.search("not a log line"));
    }
}