package com.google;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VideoPlayer {
Queue<String> q = new PriorityQueue<String> (); 
Boolean t=false;
  private final VideoLibrary videoLibrary;
  //private VideoPlaylist videoPlaylist;
  private VideoPlaylist videoPlaylist = new VideoPlaylist();

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
	  if(videoLibrary.getVideos().size()==0) {
    System.out.println("No videos to show");
	  } else {
		  System.out.println("Here's a list of all available videos:");
	        for(Video v : videoLibrary.getVideos()) {
	            System.out.println(v.getTitle()+" "+ v.getVideoId()+" "+v.getTags());
	        }
	  }
  }

  public void playVideo(String videoId) {

	  q.add(videoId);
	  if (q.size()==1) {
	  System.out.println("Playing video: "+ videoLibrary.getVideo(videoId).getTitle());
  } else {
	  System.out.println("Stopping video: "+ videoLibrary.getVideo(q.remove()).getTitle());

	  System.out.println("Playing video: "+ videoLibrary.getVideo(q.peek()).getTitle());
	  
  }
  }

  public void stopVideo() {
	  if (q.size()<1) {
    System.out.println("Cannot stop video: No video is currently playing");
	  } else {
		  System.out.println("Stopping video: "+ videoLibrary.getVideo(q.remove()).getTitle());
	  }
  }

  public void playRandomVideo() {
	  if(q.size()>0) {
		  Video v = getRandomElement(videoLibrary.getVideos());
		    System.out.println("Stopping video: "+ videoLibrary.getVideo(q.remove()).getTitle());
		    q.add(v.getVideoId());
			  System.out.println("Playing video: "+ videoLibrary.getVideo(q.peek()).getTitle());
	} else { 
		 Video vi = getRandomElement(videoLibrary.getVideos());
		 q.add(vi.getVideoId());
		  System.out.println("Playing video: "+ videoLibrary.getVideo(q.peek()).getTitle());
	}
  }
// i should fix so that i know what video is paused 
  public void pauseVideo() {
	  if (q.size()>0 && t==true) {
		  System.out.println("Video already paused: "+videoLibrary.getVideo(q.peek()).getTitle());
	  }
	  if(q.size()>0 && t==false) {
		    System.out.println("Pausing video: "+videoLibrary.getVideo(q.peek()).getTitle());
		    t=true;
	  } 
	  if (q.size()==0) {
		  System.out.println("Cannot pause video: No video is currently playing");
	  }
  }

  public void continueVideo() {
	  if (q.size()==0) {
		    System.out.println("Cannot continue video: No video is currently playing");
	  } else {
	  if (t==false) {
    System.out.println("Cannot continue video: Video is not paused");
  } else {
	    System.out.println("Continuing video: "+ videoLibrary.getVideo(q.peek()).getTitle());
	    t=false;
  }
	  }
  }

  public void showPlaying() {
	  if (q.size()>0) {
		  if(t==true)
		  System.out.println("Currently playing: "+videoLibrary.getVideo(q.peek()).getTitle()+" ("+ videoLibrary.getVideo(q.peek()).getVideoId()+") "+videoLibrary.getVideo(q.peek()).getTags()+" - PAUSED");
		  else 
		  System.out.println("Currently playing: "+videoLibrary.getVideo(q.peek()).getTitle()+" ("+ videoLibrary.getVideo(q.peek()).getVideoId()+") "+videoLibrary.getVideo(q.peek()).getTags());

	  }
	  else {
	System.out.println("No video is currently playing");

	  }
  }

public void createPlaylist(String playlistName) {
	VideoPlaylist p = new VideoPlaylist(playlistName);
	//System.out.println(p.getTitle());
	p.addPlaylist(playlistName);

Boolean b = false;
//for(String pl: videoPlaylist.getPlaylistNames()) {
//	System.out.println(pl);
//	if (pl.contains(playlistName)) {
//		System.out.println("Cannot create playlist: A playlist with the same name already exists");
//		b=true;
//		break;
//	}
//}
	if(b==false) {
	System.out.println("Successfully created new playlist: "+playlistName);
	p.addPlaylist(playlistName);

}

  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    Boolean t = null, t1 = null;
	  for(Video v : videoLibrary.getVideos()) {
          if (v.getVideoId().equals(videoId)) {
        	 t=true;
        	 break;
          }
      }	
	  for (String s: videoPlaylist.getListA()) {
		  if(s.equals(playlistName)) {
			  t1= true;
			  break;
		  }
	  }
	  if(t==true && t1==true) {
		   videoPlaylist.addVid(playlistName, videoId);
		   System.out.println("Added video to "+videoPlaylist.getPlaylist(playlistName)+":"+videoLibrary.getVideo(videoId).getTitle());

	  } else {
		  
	  }
	  
	  
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
	  searchTerm.toLowerCase();
	  String strArr[];
	  int i=1;
      // create a new ArrayList
      List<String> arrlist = new ArrayList<String>();

	  for(Video v: videoLibrary.getVideos()) {
		  if(v.getTitle().toLowerCase().contains(searchTerm)|| v.getTags().contains(searchTerm)) {
		
			  String entry=" "+v.getTitle() +"("+v.getVideoId() +")"+v.getTags();

			arrlist.add(entry);
		  }
	  }
	  System.out.println("Here are the results for "+searchTerm+" :");

arrlist.sort(null);
	  for (int x = 0 ; x < arrlist.size(); x++) {
		  System.out.println(x+") " + arrlist.get(x));
		  arrlist.get(x).concat(String.valueOf(x));
	  }
    System.out.println("Would you like to play any of the above? If yes, specify the number of the video.\r\n"
    		+ "If your answer is not a valid number, we will assume it's a no.");
    var scanner = new Scanner(System.in);
    if(scanner.hasNextInt()) {
        int num = scanner.nextInt();
        if(num<i+1) {
        	System.out.println("Valid");
      	  for (int x = 0 ; x < arrlist.size(); x++) {
    		 if(arrlist.get(x).contains(String.valueOf(num))) {
    			 String value =arrlist.get(x).substring(arrlist.get(x).indexOf("(")+1, 
    					 arrlist.get(x).indexOf(")"));
    			 playVideo(value);
    	  }
    	  }
        }
    }

  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
  public Video getRandomElement(List<Video> list)
  {
      Random rand = new Random();
      return list.get(rand.nextInt(list.size()));
  }

}