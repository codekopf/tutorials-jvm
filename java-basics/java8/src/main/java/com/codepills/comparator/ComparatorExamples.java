package com.codepills.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.codepills.entity.Document;

public class ComparatorExamples {

    public static void comparingInt() {

        // Create some documents
        Document document0 = new Document(0, "Content");
        Document document1 = new Document(1, "Improved content");
        Document document2 = new Document(2, "Better content");
        Document document3 = new Document(3, "Enhanced content");
        Document document4 = new Document(4, "Totally awesome content");

        // Documents before sorting
        System.out.println("Documents before sorting:");
        List<Document> list = Arrays.asList(document2, document1, document4, document0, document3);
        list.forEach(document -> System.out.println("Document version: " + document.getVersion()));

        // Documents sorting
        Collections.sort(list, Comparator.comparingInt(Document::getVersion));

        // Documents after sorting
        System.out.println("Documents after sorting:");
        list.forEach(document -> System.out.println("Document version: " + document.getVersion()));
    }
}
