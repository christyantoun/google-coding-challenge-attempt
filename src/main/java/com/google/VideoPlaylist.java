package com.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
class VideoPlaylist {

	  private HashMap<Integer, String> pl;
	  private String title;
	  private int i=0;
	  List<String> listA = new ArrayList<>();

	  public VideoPlaylist() {
		// TODO Auto-generated constructor stub
	}
	  
	  VideoPlaylist(String title) {
	    this.pl = new HashMap<>();
		this.title = title;
	  }

	public HashMap<Integer, String> getPl() {
		return pl;
	}

	public String getTitle() {
		return title;
	}
	
public void addPlaylist(String title){
	pl.put(i++, title);
	System.out.println(i +""+ title);
}

	List<String> getPlaylistNames() {
		    return new ArrayList<>(this.pl.values());
		  }
	
	  public List<String> getListA() {
	return listA;
}
	  

@Override
	public String toString() {
		return "VideoPlaylist [pl=" + pl + ", title=" + title + ", listA=" + listA + "]";
	}

public void setListA(List<String> listA) {
	this.listA = listA;
}

public void setPl(HashMap<Integer, String> pl) {
	this.pl = pl;
}

public void setTitle(String title) {
	this.title = title;
}

	String getPlaylist(String plId) {
		    return this.pl.get(plId);
		  }

	public void addVid(String playlistName, String videoId) {
		
	}
}
