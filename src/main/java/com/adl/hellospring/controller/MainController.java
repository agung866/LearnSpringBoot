package com.adl.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adl.hellospring.model.Profile;
import com.adl.hellospring.model.Resume;
import com.adl.hellospring.model.Skill;
import com.adl.hellospring.repository.ProfileRepository;
import com.adl.hellospring.repository.ResumeRepository;
import com.adl.hellospring.repository.SkillRepository;


@Controller
public class MainController {
	
	@Autowired
	private ProfileRepository profileRepo;
	@Autowired
	private SkillRepository skillRepo;
	@Autowired 
	private ResumeRepository rp;
	
	@GetMapping("/")
	public String helloWorld(Model model) {
		
		Profile profile=profileRepo.findById(1).get();
		model.addAttribute("profile",profile);
		
		
		List<Skill> skill=skillRepo.findAll();
		model.addAttribute("skill",skill);
		
		List<Resume> resume=rp.findAll();
		model.addAttribute("resume",resume);
	
		
		
	
		
		return "index";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String Hello() {
		return "Hello World";
	}
	
	@GetMapping("/insert")
	
	public void setData() {
	}
}
