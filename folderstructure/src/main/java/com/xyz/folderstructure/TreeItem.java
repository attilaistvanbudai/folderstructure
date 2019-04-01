package com.xyz.folderstructure;

import java.util.ArrayList;
import java.util.List;

public class TreeItem 
{ 
	public String name; 
	public List<TreeItem> children;
	
	public TreeItem(String name) {
		this.name = name;
		this.children = new ArrayList<>();
	} 
	
	public void addChild(TreeItem e){
		children.add(e);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeItem other = (TreeItem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TreeItem [name=" + name + ", children=" + children + "]";
	}
} 
