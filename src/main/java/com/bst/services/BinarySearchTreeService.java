package com.bst.services;

import com.bst.model.BinaryNode;
import org.springframework.stereotype.Service;

@Service
public class BinarySearchTreeService {

    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            return new BinaryNode(value);
        }

        if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
        } else {
            currentNode.right = insert(currentNode.right, value);
        }
        return currentNode;
    }

    public BinaryNode buildTree(int[] values) {
        BinaryNode root = null;
        for (int value : values) {
            root = insert(root, value);
        }
        return root;
    }
}