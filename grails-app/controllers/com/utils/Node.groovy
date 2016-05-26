package com.utils

/**
 * Created by Administrator on 2016/4/24 0024.
 */
class Node {
    public String name = null;
    public ArrayList<Node> relationNodes = new ArrayList<Node>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getRelationNodes() {
        return relationNodes;
    }

    public void setRelationNodes(ArrayList<Node> relationNodes) {
        this.relationNodes = relationNodes;
    }
}
