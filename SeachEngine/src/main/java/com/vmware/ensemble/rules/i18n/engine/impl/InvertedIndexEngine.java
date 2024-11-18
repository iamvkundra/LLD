package com.vmware.ensemble.rules.i18n.engine.impl;

import com.vmware.ensemble.rules.i18n.engine.SearchEngine;
import com.vmware.ensemble.rules.i18n.model.Document;
import com.vmware.ensemble.rules.i18n.model.Position;

import java.util.*;

public class InvertedIndexEngine implements SearchEngine {

    private final Map<Integer, Document> documents;
    private final Map<String, List<Position>> invertedIndex;

    public InvertedIndexEngine() {
        this.documents = new HashMap<>();
        this.invertedIndex = new HashMap<>();
    }

    @Override
    public void add(Document document) {
        String[] words = document.text.toLowerCase().split("\\s+");
        for (int i=0; i<words.length; i++) {
            invertedIndex.computeIfAbsent(words[i], k -> new ArrayList<>()).add(new Position(document.documentId, i));
        }
        documents.put(document.documentId, document);
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
