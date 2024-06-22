package com.garbuz.resume.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.service.ResumeService;

@Controller
@RequestMapping("/resume")
public class ResumeController {
	
	private static final String VIEW_RESUME_PAGE = "resumePage";

	private static final Logger LOG = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	private ResumeService resumeService;

	@GetMapping("/showAll")
	public ModelAndView showAll() {
		LOG.info("Show all resumes");
		ModelAndView mv = new ModelAndView();
		mv.setViewName(VIEW_RESUME_PAGE);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.RESUME_LIST_FRAGMENT);
		
		List<Resume> resumes = this.resumeService.findAllResumes();
		mv.addObject("resumeList", resumes);
		LOG.info("Displaying {} resumes", CollectionUtils.size(resumes));
		return mv;
	}
	
	@GetMapping("/show/{id}")
	public ModelAndView showResume(@PathVariable(name="id", required = true) final String id) {
		LOG.info("Show resume request for resumeId={}", id);
		Long resumeId = Long.valueOf(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName(VIEW_RESUME_PAGE);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.RESUME_FRAGMENT);
		
		Resume resume = this.resumeService.findCompleteResumeById(resumeId);
		mv.addObject("resume", resume);
		LOG.info("Displaying {}", resume);
		return mv;
	}
    @GetMapping("/create")
    public ModelAndView showCreateResumeForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject(new Resume());
		mv.setViewName(VIEW_RESUME_PAGE);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.RESUME_CREATE_FRAGMENT);
		return mv;
    }

    @PostMapping("/create")
    public String createResume(@ModelAttribute("resume") Resume resume) {
        resumeService.saveOrCreateNew(resume);
        return "redirect:/resume/showAll";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditResumeForm(@PathVariable("id") Long id) {
    	LOG.info("Displaying resume for {}", id);
        Resume resume = resumeService.findResumeById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject(resume);
		mv.setViewName(VIEW_RESUME_PAGE);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.RESUME_EDIT_FRAGMENT);
		return mv;
    }

    @PostMapping("/edit")
    public String updateResume(@ModelAttribute("resume") Resume resume) {
        resumeService.saveOrCreateNew(resume);
        return "redirect:/resume/showAll";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteResumeForm(@PathVariable("id") Long id) {
        Resume resume = resumeService.findResumeById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject(resume);
		mv.setViewName(VIEW_RESUME_PAGE);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.RESUME_DELETE_FRAGMENT);
		return mv;
    }
    
    @PostMapping("/delete/{id}")
    public String deleteResume(@PathVariable("id") Long id) {
        resumeService.remove(id);
        return "redirect:/resume/showAll";
    }
}
