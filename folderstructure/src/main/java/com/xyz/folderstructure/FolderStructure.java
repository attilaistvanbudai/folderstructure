package com.xyz.folderstructure;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class FolderStructure {

	public Graph createWritableFolderGraph(List<String> readableFolders, List<String> writableFolders) throws IllegalAccessException {
		if(readableFolders== null || writableFolders== null){
			throw new IllegalAccessException("Cannot pass null!");
		}
		
		List<String[]> readlist = readableFolders.stream().map(x -> x.split("/")).sorted(new FolderComparator()).collect(Collectors.toList());

		Graph graph = new Graph();
		for (String[] node : readlist) {
			graph.addNode(node);
		}

		List<String[]> writelist = writableFolders.stream().map(x -> x.split("/")).sorted(new FolderComparator()).collect(Collectors.toList());

		Graph graphWrite = new Graph();
		for (String[] node : writelist) {
			graph.addWitableNode(node, graphWrite);
		}
		return graphWrite;
	}

}
