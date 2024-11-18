package com.vmware.ensemble.rules.i18n.engine.impl;

import com.vmware.ensemble.rules.i18n.engine.SearchEngine;
import com.vmware.ensemble.rules.i18n.model.Document;

import java.util.*;

public class TrieEngine implements SearchEngine {

    private TrieNode root;

    public TrieEngine() {
        this.root = new TrieNode();
    }

    @Override
    public void add(Document document) {
        String[] words = document.text.toLowerCase().split("\\s+");
        for (String word : words) {
            addToTrie(word, document.documentId);
        }
    }

    private void addToTrie(String word, int documentId) {
        TrieNode node = this.root;
        for (Character ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
        node.documents.add(documentId);
    }

    @Override
    public Set<Integer> search(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        if (words.length == 1) {
            return searchWord(words[0]);
        } else {
            return searchText(words);
        }
    }

    private Set<Integer> searchText(String[] words) {
        Set<Integer> findFirstWord = searchWord(words[0]);
        for (int i=1; i<words.length; i++) {
            findFirstWord.retainAll(searchWord(words[i]));
        }
        return findFirstWord;
    }

    private Set<Integer> searchWord(String word) {
        TrieNode node = this.root;
        for (Character ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return Collections.emptySet();
            }
            node = node.children.get(ch);
        }
        return node.documents;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        Set<Integer> documents;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
            this.documents = new HashSet<>();
        }
    }
}
