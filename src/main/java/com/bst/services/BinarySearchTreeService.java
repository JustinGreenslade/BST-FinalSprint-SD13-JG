package com.bst.services;

import com.bst.model.BinaryNode;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class BinarySearchTreeService {

    // Existing method – sequential insert (keeps current behavior)
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

    public BinaryNode buildBalancedTree(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        int[] uniqueSorted = Arrays.stream(values)
                .distinct()
                .sorted()
                .toArray();

        return buildBalancedFromSorted(uniqueSorted, 0, uniqueSorted.length - 1);
    }

    private BinaryNode buildBalancedFromSorted(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        BinaryNode node = new BinaryNode(arr[mid]);

        node.left = buildBalancedFromSorted(arr, start, mid - 1);
        node.right = buildBalancedFromSorted(arr, mid + 1, end);

        return node;
    }
}