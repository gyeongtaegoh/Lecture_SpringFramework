package com.clustering.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clustering.project.dao.OrganizationDao;

@Service
public class OrganizationService {
	@Autowired
	OrganizationDao dao;
	
	
	public Object getObject_List(String sqlMapId, Object dataMap) {
		//MemberDao dao = new MemberDao();
		Object resultObject = dao.getList("organization.list", dataMap); 
		
		return resultObject;
	}
	public Object getObject_Read(String sqlMapId, Object dataMap) {
		Object resultObject = dao.getObject("organization.read", dataMap);
		return resultObject;
	}
	public List<Object> getObject_Insert_List(String sqlMapId, Object dataMap) {
		List<Object> resultObject = new ArrayList<Object>();
		dao.saveObject("organization.insert", dataMap);
		resultObject = (List<Object>) dao.getList("organization.list", dataMap);
			
		return resultObject;
	}
	public List<Object> getObject_Delete_List(String sqlMapId, Object dataMap) {
		List<Object> resultObject = new ArrayList<Object>();
		resultObject = (List<Object>)dao.getList("organization.list2", dataMap);
		for(int i = 0; i < resultObject.size(); i++) {
			//if( ((Map<String, Object>)resultObject).get(key) == null) {
			////	
			//}
		}
		dao.deleteObject("organization.delete", dataMap);
		resultObject = (List<Object>)(dao.getList("organization.list", dataMap));
		
		return resultObject;
	}
	
	public List<Object> getObject_Update_List(String sqlMapId, Object dataMap){
		List<Object> resultObject = new ArrayList<Object>();
		dao.saveObject("organization.update", dataMap);
		resultObject = (List<Object>) dao.getList("organization.list", dataMap);
		
		return resultObject;
	}
	
}
