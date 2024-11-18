package com.vmware.ensemble.rules.i18n.engine.impl;

import com.vmware.ensemble.rules.i18n.engine.SearchEngine;
import com.vmware.ensemble.rules.i18n.model.Document;
import com.vmware.ensemble.rules.i18n.model.Position;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class InvertedIndexEngine implements SearchEngine {

    private final ConcurrentHashMap<Integer, Document> documents;
    private final ConcurrentHashMap<String, List<Position>> invertedIndex;
    private final ReentrantLock lock;

    public InvertedIndexEngine() {
        this.documents = new ConcurrentHashMap<>();
        this.invertedIndex = new ConcurrentHashMap<>();
        this.lock = new ReentrantLock();
    }

    @Override
    public synchronized void add(Document document) {
        try {
            lock.lock();
            String[] words = document.text.toLowerCase().split("\\s+");
            for (int i = 0; i < words.length; i++) {
                invertedIndex.computeIfAbsent(words[i], k -> new ArrayList<>()).add(new Position(document.documentId, i));
            }
            documents.put(document.documentId, document);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Set<Integer> search(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        List<Position> firstWord = invertedIndex.get(words[0]);

        if (firstWord == null) {
            return Collections.emptySet();
        }

        Set<Integer> result = new HashSet<>();

        for (Position position : firstWord) {
            int prevPos = position.positionIndex;
            int docId = position.documentId;
            boolean firstWordMatched = true;

            for (int i=1; i<words.length; i++) {
                List<Position> current = invertedIndex.get(words[i]);
                if (current == null) {
                    firstWordMatched = false;
                    break;
                }
                boolean secondWordMatched = false;
                for (Position second : current) {
                    if (second.documentId == docId && second.positionIndex == prevPos+1) {
                        secondWordMatched = true;
                        prevPos = second.positionIndex;
                        break;
                    }
                }
                if (!secondWordMatched) {
                    firstWordMatched = false;
                    break;
                }
            }
            if (firstWordMatched) {
                result.add(docId);
            }
        }
        return result;
    }
}
