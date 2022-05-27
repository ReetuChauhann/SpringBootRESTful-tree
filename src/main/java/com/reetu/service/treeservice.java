package com.reetu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Tree;

public interface treeservice {
	public String add(Tree t, MultipartFile image);
	public List<Tree> getall();
	public Tree gettreebyid(int tid);
	public List<Tree> getlikename(String name);
	public byte[] getimage(int tid);
	public String update(Tree t, MultipartFile image);
	public String delete(int tid);
	public List<Integer> getallids();

}
