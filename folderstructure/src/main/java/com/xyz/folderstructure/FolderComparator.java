package com.xyz.folderstructure;

import java.util.Comparator;

public class FolderComparator implements Comparator<String[]>{

	@Override
	public int compare(String[] o1, String[] o2) {
		// TODO Auto-generated method stub
		return o1.length-o2.length;
	}
	
}
