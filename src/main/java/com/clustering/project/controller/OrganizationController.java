/**
 * It's Designed For incubation Center
 * @author ohsanghun
 * @version     %I%, %G%
 * @since       1.0
 */
package com.clustering.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clustering.project.javabean.OrganizationBean;
import com.clustering.project.service.OrganizationService;
import com.clustering.project.util.CommonUtil;

/**
 * @author ohsanghun
 * get it Mapping classlevel (JavaBean, HttpServletRequest, Model, View, ModelAndView)
 */

// ? delete @Controller, 
//@Controller
@Component
@RequestMapping(value = "/organization")
public class OrganizationController {

	@Autowired
	private OrganizationService service;
	
	// ? add View class
	@RequestMapping(value = "/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public Model edit(OrganizationBean paramMap, HttpServletRequest request, Model model, String sqlMapId) {
		if(paramMap.getORGANIZATION_SEQ() == null) {
			paramMap.setORGANIZATION_SEQ(new CommonUtil().getUniqueSequence());			
		}
		model.addAttribute("resultMap", paramMap);
		
		return model;
	}
	

//	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView delete(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView, String sqlMapId) {
//		List<Object> resultList = new ArrayList<Object>();
//		resultList = (List<Object>)service.getObject_Delete_List(sqlMapId, paramMap);
//		String viewName = "/organization/list";
//		
//		modelandView.setViewName(viewName);
//		modelandView.addObject("resultList", resultList);
//		
//		return modelandView;
//		
//	}
	
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView delete(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView, String sqlMapId) {
		List<Object> resultList = new ArrayList<Object>();
		resultList = (List<Object>)service.getObject_Delete_List(sqlMapId, paramMap);
		String viewName = "/organization/list";
		
		modelandView.setViewName(viewName);
		modelandView.addObject("resultList", resultList);
		
		return modelandView;
		
	}
	
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView insert(OrganizationBean paramMap, ModelAndView modelandView, String sqlMapId) {
		List<Object> resultList = new ArrayList<Object>();
		OrganizationBean resultOrg = new OrganizationBean();
		String viewName = "/organization/list";
		
		if(service.getObject_Read(sqlMapId, paramMap) != null ) {
			resultList = service.getObject_Update_List(sqlMapId, paramMap);
		}else {
			resultList = service.getObject_Insert_List(sqlMapId, paramMap);			
		}

		modelandView.setViewName(viewName);
		modelandView.addObject("resultList", resultList);
		
		return modelandView;

	}
	
	// ? delete only method = RequestMethod.GET in @RequestMapping 
	@RequestMapping(value = "/read", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView read(OrganizationBean paramMap, ModelAndView modelandView, String sqlMapId) {
		OrganizationBean resultOrg = (OrganizationBean)service.getObject_Read(sqlMapId, paramMap);
		String viewName = "/organization/read";
				
		modelandView.setViewName(viewName);
		modelandView.addObject("paramMap", resultOrg);
		
		return modelandView;

	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView, String sqlMapId) {
		List<Object> resultList = new ArrayList<Object>();
		resultList = (List<Object>)service.getObject_List(sqlMapId, paramMap);
		String viewName = "/organization/list";

		modelandView.setViewName(viewName);
		modelandView.addObject("resultList", resultList);
		
		return modelandView;

	}
}
