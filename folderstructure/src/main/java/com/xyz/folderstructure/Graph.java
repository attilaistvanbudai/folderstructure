package com.xyz.folderstructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Graph {
	
	public TreeItem root;
	
	public Graph(){
		root = new TreeItem("");
	}
	
	public void addNode(String[] path){
		
		addNodeHelper(path);
		
	}
	
	public void addNodeForced(String[] path){
		TreeItem currentItem = root;
		for(int i=1; i<path.length; i++){
			String name = path[i];
			TreeItem newNode = new TreeItem(name);
			if(!currentItem.children.contains(newNode)){
				currentItem.children.add(newNode);
				currentItem = newNode;
			} else{
				currentItem = currentItem.children.stream().filter(x -> x.equals(newNode)).findFirst().get();
			}
		}
		
	}

	private boolean addNodeHelper(String[] path) {
		TreeItem currentItem = root;
		for(int i=1; i<path.length-1; i++){
			String name = path[i];
			Optional<TreeItem> next = currentItem.children.stream().filter(x -> x.name.equals(name)).findAny();
			if(next.isPresent()){
				currentItem = next.get();
			} else{
				return false;
			}
		}
		
		TreeItem newNode = new TreeItem(path[path.length-1]);
		
		if(!currentItem.children.contains(newNode)){
			currentItem.addChild(newNode);
		}
		return true;
		
	}
	
	public void addWitableNode(String[] path, Graph writeableGraph){
		boolean success = addNodeHelper(path);
		if(success){
			writeableGraph.addNodeForced(path);
		}
	}

	@Override
	public String toString() {
		return "Graph [root=" + root + "]";
	}
	
	
	
}