package com.bst.entity;

import jakarta.persistence.*;

@Entity
// each of mt treerecord is one saved BST submission (input + tree JSON).
public class TreeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inputNumbers;


    @Lob // found is you need to use Lob combined with TEXT for large object where my tree JSON can get long!
    @Column(columnDefinition = "TEXT")

    private String treeJson;

    public TreeRecord() {}

    public TreeRecord(String inputNumbers, String treeJson) {
        this.inputNumbers = inputNumbers;
        this.treeJson = treeJson;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }
}