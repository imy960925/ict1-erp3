package com.ict.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ict.erp.service.LevelService;
import com.ict.erp.vo.LevelInfo;

@Controller
public class LevelInfoController {

	@Autowired
	private LevelService ls;

	@RequestMapping(value = "/levelinfo", method = RequestMethod.GET)
	public @ResponseBody List<LevelInfo> getLevelInfoList(@ModelAttribute LevelInfo li) {
		System.out.println("IN");
		return ls.getLevelInfoList(li);
		
		
		//@RequestMapping(value = "/levelinfo", method = RequestMethod.GET)
		// public String getLevelInfoList(@ModelAttribute LevelInfo li,Model m) {
		// System.out.println(li);
		// m.addAttribute("liList",ls.getLevelInfoList(li));
		// return "levelinfo/list";
		// }

	}

	@RequestMapping(value = "/levelinfo/{liNum}", method = RequestMethod.GET)
	public @ResponseBody LevelInfo getLevelInfo(@PathVariable Integer liNum) {
		return ls.getLevelInfo(liNum);

	}
	

	@RequestMapping(value="/levelinfo",method=RequestMethod.POST)
	public @ResponseBody int insertLevelInfo(@RequestBody LevelInfo li) {
		return ls.insertLevelInfo(li);
		
	//@RequestMapping(value = "/levelinfo1", method = RequestMethod.POST)
	//public String getLevelInfoList2(@ModelAttribute LevelInfo li, Model m) {
		//System.out.println(li);
		//m.addAttribute("insertliList", ls.insertLevelInfo(li));
		//return "levelinfo/insert";
	}
	
	@RequestMapping(value="levelinfo/{liNum}",method=RequestMethod.PUT)
	public @ResponseBody int updateLevelInfo(@RequestBody LevelInfo li,@PathVariable int liNum) {
		li.setLiNum(liNum);
		return ls.updateLevelInfo(li);
		
	}
	
	@RequestMapping(value="levelinfo/{liNum}",method=RequestMethod.DELETE)
	public @ResponseBody int deleteLevelInfo(@PathVariable int liNum) {
		return ls.deleteLevelInfo(liNum);
		
	}
}

/*	@RequestMapping(value = "/levelinfo2", method = RequestMethod.POST)
	public String getLevelInfoList1(@ModelAttribute LevelInfo li, Model m) {
		System.out.println(li);
		m.addAttribute("updateliList", ls.updateLevelInfo(li));
		return "levelinfo/list";
	}
*/
	/*@RequestMapping(value = "/levelinfo3", method = RequestMethod.GET)
	public ModelAndView getLevelInfList2(@ModelAttribute LevelInfo li, ModelAndView mav) {
		mav.setViewName("levelinfo/list");
		mav.addObject("liList", ls.getLevelInfoList(li));
		return mav;
	}

	@RequestMapping(value = "/levelinfo4", method = RequestMethod.POST)
	public @ResponseBody List<LevelInfo> getLevelInfoList4(@RequestBody LevelInfo li) {
		return ls.getLevelInfoList(li);
	}

}*/
