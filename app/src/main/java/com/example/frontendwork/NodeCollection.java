package com.example.frontendwork;//import org.jetbrains.annotations.NotNull;

import static java.lang.Integer.valueOf;

import androidx.annotation.NonNull;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class NodeCollection {

    private final ArrayList<Node> nodes;
/****************************************************/
/*************    SUPPORT MAP BUILDER  **************/
/****************************************************/
    /****************************************************/
    public Node locateNodeBy(int nodeID) {
        for (Node n : nodes) {
            if (nodeID == n.getID()) {
                return n;
            }
        }
        return new Node();
    }

    public ArrayList<Node> arrayList() {
        return nodes;
    }

    public Node get(int index) {
        return nodes.get(index);
    }
/****************************************************/
/**************         BUILD      ******************/
/****************************************************/
    /****************************************************/
    public NodeCollection(InputStream prc) throws FileNotFoundException {
//        java.io.File prc = new java.io.File("src/generator4.csv");
        Scanner fileRef = new Scanner(prc);
        nodes = new ArrayList<Node>();
        Node node;
        while (fileRef.hasNext()) {
            String line = fileRef.nextLine();
            node = mapFields(line);
            nodes.add(node);
        }
        fileRef.close();
    }

    //private @NotNull
    Node mapFields(String line) {
        String[] stringArray = line.split(",");
        Node n = new Node();
        n.setID(valueOf(stringArray[0]));
        n.setYesID(valueOf(stringArray[1]));
        n.setNoID(valueOf(stringArray[2]));
        n.setDescription(stringArray[3]);
        n.setQuestion(stringArray[4]);
        return n;
    }

    @NonNull
    public String toString() {
        String str = "";
        for (Node n : nodes) {
            str += n.toString() + "\n";
        }
        return str;
    }
}
