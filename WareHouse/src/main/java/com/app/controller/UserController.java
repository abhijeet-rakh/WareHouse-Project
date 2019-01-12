package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.app.excelview.UserExcelView;
import com.app.excelview.UserExcelViewById;
import com.app.model.User;
import com.app.pdfview.UserPdfView;
import com.app.pdfview.UserPdfViewById;
import com.app.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	@RequestMapping(value="/register")
	public String regUser(ModelMap map) {
		map.addAttribute("user",new User());
		return "UserRegister";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user,ModelMap map) {
		
		System.out.println(" "+user.getUserid()+"  "+user.getUserName()+" "+user.getPassword()+"  "+user.getMobile()+"  "+user.getMail()+" "+user.getRoles().toString());
    	
		Integer id=service.saveUser(user);
		
		String msg="record inserted no is "+id;
	
		//add attribute to map
		map.addAttribute("message",msg);
		
		//clean the object 
		map.addAttribute("user",new User());
		
		return "UserRegister";
	}
	
	@RequestMapping(value="all")
	public String getAllUser(ModelMap map) {
		List<User> list=service.getAllUser();
		
		map.addAttribute("data",list);
		return "UserData";
	}
	
	
	@RequestMapping(value="delete")
	public String deleteUser(@RequestParam("uid") Integer id,ModelMap map) {
	    service.deleteUser(id);
	
	    String msg="deleted "+id+" number record";
	    
	    map.addAttribute("message",msg);
	
	    //again get element back 
	    List<User> list=service.getAllUser();
		
	    //add data to map
		map.addAttribute("data",list);
	
	    return "UserData";
	}
	
	
	@RequestMapping(value="viewOne")
	public String getUserById(@RequestParam Integer uid,ModelMap map) {
		
		User user=service.getUserById(uid);
		
		map.addAttribute("user",user);
		
		return "UserView";
	}
	
	
	@RequestMapping(value="editOne")
	public String editUser(@RequestParam Integer uid,ModelMap map) {
		
		map.addAttribute("user",service.getUserById(uid));
		
		return "UserEdit";
	}
	
	@RequestMapping(value="update")
	public String updateUser(@ModelAttribute User user,ModelMap map) {
		
		//call service
		service.updateUser(user);
		
		//add to map attribute
		map.addAttribute("message","Record "+user.getUserid()+" updated");
		
		//add many record to map
		map.addAttribute("data",service.getAllUser());
		
		return "UserData";
	}
	
	
	@RequestMapping("excelall")
	public ModelAndView getAllUserExcel() {
		
		List<User> list=service.getAllUser();
		
	    return new ModelAndView(new UserExcelView(),"list",list);
	}
	
	
	@RequestMapping("excelOne")
	public ModelAndView getUserById(@RequestParam Integer uid) {
           User user=service.getUserById(uid);
           
           return new ModelAndView(new UserExcelViewById(),"onedata",Arrays.asList(user));
	}
	
	@RequestMapping("pdfExp")
    public ModelAndView getAllUserforPdf() {
		List<User> list=service.getAllUser();
		
		return new ModelAndView(new UserPdfView(),"list",list);
	}
	
	@RequestMapping("pdfOne")
	public ModelAndView getUserPdfById(@RequestParam Integer uid) {
		User user=service.getUserById(uid);
		       
		return new ModelAndView(new UserPdfViewById(),"onedata",Arrays.asList(user));
	}


}
