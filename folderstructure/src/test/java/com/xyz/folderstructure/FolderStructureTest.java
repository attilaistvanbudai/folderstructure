package com.xyz.folderstructure;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertEquals;

public class FolderStructureTest {
	
	FolderStructure folderStructure;
	
	@Before
	public void setup(){
		folderStructure = new FolderStructure();
	}
	
	@Test(expected = IllegalAccessException.class)
	public void testGraphWithNullInput() throws IllegalAccessException{
		
		Graph g = folderStructure.createWritableFolderGraph(null, null);
	}
	
	@Test
	public void testEmptyGraph() throws IllegalAccessException{
		List<String> readList = new ArrayList<>();
		List<String> writeList = new ArrayList<>();
		
		Graph g = folderStructure.createWritableFolderGraph(readList, writeList);
		
		assertEquals(0, g.root.children.size());
	}
	
	@Test
	public void testGraphWithOneElement() throws IllegalAccessException{
		List<String> readList = Lists.newArrayList("/abc");
		List<String> writeList = Lists.newArrayList("/abc");
		
		Graph g = folderStructure.createWritableFolderGraph(readList, writeList);
		
		assertEquals(1, g.root.children.size());
		assertEquals("abc", g.root.children.get(0).name);
	}
	
	@Test
	public void testGraphWithoutRootConnection() throws IllegalAccessException{
		List<String> readList = Lists.newArrayList("/abc/abcd");
		List<String> writeList = Lists.newArrayList("/abc/abcd");
		
		Graph g = folderStructure.createWritableFolderGraph(readList, writeList);
		
		assertEquals(0, g.root.children.size());
	}
	
	@Test
	public void testGraphWithputWriteList() throws IllegalAccessException{
		List<String> readList = Lists.newArrayList("/abc");
		List<String> writeList = Lists.newArrayList();
		
		Graph g = folderStructure.createWritableFolderGraph(readList, writeList);
		
		assertEquals(0, g.root.children.size());
	}
	
	@Test
	public void testMultipleChildrenOneWrite() throws IllegalAccessException{
		List<String> readList = Lists.newArrayList("/a", "/b", "/c");
		List<String> writeList = Lists.newArrayList("/b");
		
		Graph g = folderStructure.createWritableFolderGraph(readList, writeList);
		
		assertEquals(1, g.root.children.size());
		assertEquals("b", g.root.children.get(0).name);
	}
	
	@Test
	public void testIfOneWriteFolderIsUnderOther() throws IllegalAccessException{
		List<String> readList = Lists.newArrayList("/a", "/b", "/c");
		List<String> writeList = Lists.newArrayList("/b", "/b/c");
		
		Graph g = folderStructure.createWritableFolderGraph(readList, writeList);
		
		assertEquals(1, g.root.children.size());
		assertEquals("b", g.root.children.get(0).name);
		assertEquals("c", g.root.children.get(0).children.get(0).name);
	}

}
