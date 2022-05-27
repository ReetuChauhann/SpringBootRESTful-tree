package com.reetu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Tree;
import com.reetu.dao.treerepo;

@Service
public class treeserviceimpl implements treeservice {
	@Autowired
	treerepo tr;

	@Override
	public String add(Tree t, MultipartFile image) {
		// TODO Auto-generated method stub
		return tr.add(t, image);
	}

	@Override
	public List<Tree> getall() {
		// TODO Auto-generated method stub
		return tr.getall();
	}

	@Override
	public Tree gettreebyid(int tid) {
		// TODO Auto-generated method stub
		return tr.gettreebyid(tid);
	}

	@Override
	public List<Tree> getlikename(String name) {
		// TODO Auto-generated method stub
		return tr.getlikename(name);
	}

	@Override
	public byte[] getimage(int tid) {
		// TODO Auto-generated method stub
		return tr.getimage(tid);
	}

	@Override
	public String update(Tree t, MultipartFile image) {
		// TODO Auto-generated method stub
		return tr.update(t, image);
	}

	@Override
	public String delete(int tid) {
		// TODO Auto-generated method stub
		return tr.delete(tid);
	}

	@Override
	public List<Integer> getallids() {
		// TODO Auto-generated method stub
		return tr.getallids();
	}

}
