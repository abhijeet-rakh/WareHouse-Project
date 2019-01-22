package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping(value = "/docs")
public class DocumentController {

	@Autowired
	private IDocumentService service;

	@RequestMapping(value = "/all")
	public String showDocs(ModelMap map) {
		List<Object[]> list = service.getObjectIdAndNames();
		map.addAttribute("list", list);
		return "Document";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadDoc(@RequestParam CommonsMultipartFile fileOb, ModelMap map) {
		if (fileOb != null) {
			Document doc = new Document();
			doc.setFileName(fileOb.getOriginalFilename());
			doc.setFileData(fileOb.getBytes());
			Integer id = service.saveDocument(doc);
			map.addAttribute("message", "saved with id=" + id);
		}

		// show all uploaded docs
		List<Object[]> list = service.getObjectIdAndNames();
		map.addAttribute("list", list);

		return "Document";
	}

	@RequestMapping(value = "/download")
	public void downloadDoc(@RequestParam Integer docid, HttpServletResponse res) {
		Document doc = service.getDocumentById(docid);
  
		//add header
		res.addHeader("Content-Disposition","attachment;filename="+doc.getFileName());
		
		try {
			FileCopyUtils.copy(doc.getFileData(), res.getOutputStream());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}