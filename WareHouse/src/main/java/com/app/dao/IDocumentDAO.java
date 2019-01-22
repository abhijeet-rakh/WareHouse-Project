package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDAO {
	
	public Integer saveDocument(Document doc);
	public List<Object[]> getObjectIdAndNames();
	public Document getDocumentById(Integer id);
	
}
