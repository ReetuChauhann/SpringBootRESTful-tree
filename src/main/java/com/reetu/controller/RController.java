package com.reetu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Tree;
import com.reetu.service.treeservice;

@RestController
public class RController {
	   @Autowired
	   treeservice ts;
	   
	   @RequestMapping("/")
	   public String home() {
		   return "Welcome Honey";
	   }
	   
	   @PostMapping("/addtree")
	   public ResponseEntity<String> addtree(@RequestPart("Tree") Tree t,@RequestPart("image") MultipartFile image){
		   String s=ts.add(t, image);
		   if(s.equals("success")) {
			   return new ResponseEntity<String>(s, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<String>(s,HttpStatus.NOT_MODIFIED);
		   }
	   }
	   
	   @GetMapping("/getall")
	   public List<Tree> getall(){
		   List<Tree> t=ts.getall();
		   return t;
	   }
	   
	   @GetMapping("/gettreebyid/{tid}")
	   public Tree gettreebyid(@PathVariable("tid") int tid) {
		   Tree t=ts.gettreebyid(tid);
		   return t;
	   }
	   
	   @GetMapping("/getlikenamet/{name}")
	   public List<Tree> getlikenamet(@PathVariable("name") String name){
		   List<Tree> t=ts.getlikename(name);
		   return t;
	   }
	   
	   @GetMapping("/getImage/{tid}")
	   public byte[] getimage(@PathVariable("tid") int tid) {
		   byte[] b=ts.getimage(tid);
		   return b;
		   
	   }
	   
	   @PutMapping("/update")
	   public ResponseEntity<String> update(@RequestPart("Tree") Tree t, @RequestPart("image") MultipartFile image){
		   String s=ts.update(t, image);
		   if(s.equals("success")) {
			   return new ResponseEntity<String>(s, HttpStatus.OK);
		   }else {
			   return new ResponseEntity<String>(s, HttpStatus.NOT_MODIFIED);
		   }
	   }
	   
	   @DeleteMapping("/delete/{tid}")
	   public String delete(@PathVariable("tid") int tid) {
		   String s=ts.delete(tid);
		   return s;
	   }
	   
	   @GetMapping("/getallids")
	   public List<Integer> getallids(){
		   List<Integer> list=ts.getallids();
		   return list;
	   }

}
