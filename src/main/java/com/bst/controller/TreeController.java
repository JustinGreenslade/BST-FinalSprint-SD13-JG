package com.bst.controller;

import com.bst.entity.TreeRecord;
import com.bst.model.BinaryNode;
import com.bst.services.BinarySearchTreeService;

import com.fasterxml.jackson.core.JsonProcessingException; // handles the exceptions
import com.fasterxml.jackson.databind.ObjectMapper; // converts java objects and maps to json string
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap; // helps keep order easier
import java.util.List;
import java.util.Map; // I use map to build my json like tree structure

@RestController
@CrossOrigin(origins = "*") // im allowed all but in day to day i would specify a direct url

public class TreeController {

    @Autowired
    private BinarySearchTreeService bstService;

    @Autowired
    private com.bst.repository.TreeRecordRepository repository;

    @Autowired
    private ObjectMapper objectMapper; // converts my java objects to json strings

    // added a helper method to convert a BinaryNode into a Map for my json output
    private Map<String, Object> nodeToMap(BinaryNode node) {
        if (node == null) {
            return null;
        }

        Map<String, Object> map = new LinkedHashMap<>(); // keeps my order of value left to right logic to match project example
        map.put("value", node.value);
        map.put("left", nodeToMap(node.left));
        map.put("right", nodeToMap(node.right));

        return map;
    }

    @PostMapping("/process-numbers")

    public Map<String, Object> processNumbers(@RequestBody List<Integer> numbers) throws JsonProcessingException {

        // changed my list<Interger> to int array for buildTree.
        int[] valuesArray = new int[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            valuesArray[i] = numbers.get(i);
        }

        BinaryNode rootNode = bstService.buildTree(valuesArray);

        Map<String, Object> result = new LinkedHashMap<>(); //  new map to hold my final response wrapped in my root
        result.put("root", nodeToMap(rootNode));
        //  converts to a custom string to match figure 4 in project example
        String inputStr = numbers.toString().replace("[", "").replace("]", "").trim();
        // converts my results to json string for database storing
        String treeJsonStr = objectMapper.writeValueAsString(result);
        TreeRecord record = new TreeRecord(inputStr, treeJsonStr);
        repository.save(record);

        return result;
    }

    @GetMapping("/previous-trees")

    public List<TreeRecord> getPreviousTrees() {
        return repository.findAll();
    }
}