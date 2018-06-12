package com.clustering.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clustering.project.dao.MemberDao;

@Service

public class MemberService {
	@Autowired
	MemberDao dao;
	public Object getObject(String sqlMapld, Object dataMap) {
		//MemberDao dao = new MemberDao();
		Object resultObject = dao.getList(sqlMapld, dataMap); 
		
		return resultObject;
	}
}
