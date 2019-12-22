import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.sound.sampled.DataLine;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }

		@Override
		public String toString() {
			return "DoublyLinkedListNode [data=" + data + ", next=" + next + ", prev=" + prev + "]";
		}
        
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    	DoublyLinkedListNode currentNode = head;
    	
    	if(currentNode.data >= data) {
    		DoublyLinkedListNode returnNode = new DoublyLinkedListNode(data);
    		returnNode.prev = null;
    		returnNode.next = currentNode;
    		currentNode.prev = returnNode;
    		return returnNode;
    	}
    	
    	while(currentNode.next != null) {
    		currentNode = currentNode.next;
    		if(currentNode.data >= data) {
    			DoublyLinkedListNode addedNode = new DoublyLinkedListNode(data);
    			addedNode.next = currentNode;
    			addedNode.prev = currentNode.prev;
    			currentNode.prev.next = addedNode;
    			currentNode.prev = addedNode;
    			return head;
    		}
    	}
    	
    	DoublyLinkedListNode returnNode = new DoublyLinkedListNode(data);
		returnNode.next = null;
		returnNode.prev = currentNode;
		currentNode.next = returnNode;
		return head;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

           // printDoublyLinkedList(llist1, " ", bufferedWriter);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
