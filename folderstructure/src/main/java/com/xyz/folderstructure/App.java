package com.xyz.folderstructure;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws IllegalAccessException {

		List<String> readableFolders = Lists.newArrayList("/var/lib/jenkins", "/var", "/var/lib", "/var/lib2");

		List<String> writableFolders = Lists.newArrayList("/var/lib2");

		Graph graph = new FolderStructure().createWritableFolderGraph(readableFolders, writableFolders);
		
		System.out.println(graph);

	}
}
