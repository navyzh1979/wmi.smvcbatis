/**
 * 
 */
package org.wminchina.crm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.entity.SysRight;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.helper.RightModuleBuilder;
import org.wmichina.crm.service.SysDefaultService;
import org.wmichina.crm.service.SysRoleUserService;

/**
 * Created on 2012-11-2 下午4:50:35.
 *
 * <p>Title:        
 * </p>
 * <p>Description:  
 * </p>
 *
 * @author andy_zhou
 * @version 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:beans.xml"})
public class MyBatisTest extends org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests {

	@Resource(name = "sysRoleUserService")
	private SysRoleUserService sysRoleUserService;
	
	@Resource(name = "sysDefaultService")
	private SysDefaultService sysDefaultService;
	
	@Test
	public void testFindRights() throws Exception{
		List<SysRight> rights = this.sysRoleUserService.findRights();
		System.out.println(Arrays.toString(rights.toArray()));
		RightModuleBuilder.initModules(rights);
	}
	
	@Test
	public void testPage() throws Exception{
		ResultPageBuilder<SysRight> pageRights = this.sysRoleUserService.findRightsByPage(new SysRight(), 2);
		System.out.println(new JSONObject(pageRights).toString());
		System.out.println(Arrays.toString(pageRights.getResultSet().toArray()));
	}
	
	
	@Test
	public void testCreateRole() throws Exception{
		//#1. query all rights
		List<SysRight> rights = this.sysRoleUserService.findRights();
		
		//#2. new role
		SysRole role = new SysRole();
		role.setRoleName("AdminSys-" + (new Random()).nextInt(Integer.MAX_VALUE));
		role.setAuditStatus(0);
		role.setIsValid(1);
		//
		List<SysRight> myRights = new ArrayList<SysRight>();
		for(int i=0;i<8;i++){
			myRights.add(rights.get(i));
		}
		role.setRoleRights(myRights);
		
		//#3. save role
		this.sysRoleUserService.createRole(role);
		System.out.println(role.toString());
	}
	
	@Test
	public void testUpdateRole() throws Exception{
		//#1. query all rights
		List<SysRight> rights = this.sysRoleUserService.findRights();
		
		//#2. select role and update it
		SysRole role = this.sysRoleUserService.selectOneRole(9);
		role.setRoleName("AdminSys-" + (new Random()).nextInt(Integer.MAX_VALUE));
		role.setAuditStatus(0);
		role.setIsValid(1);
		role.setUpdateUser("uuc");
		//
		List<SysRight> myRights = new ArrayList<SysRight>();
		for(int i=0;i<=(new Random()).nextInt(10);i++){
			myRights.add(rights.get(i));
		}
		role.setRoleRights(myRights);
		
		//#3. update role
		this.sysRoleUserService.updateRole(role);
		System.out.println(role.toString());
	}
	
	@Test
	public void testQueryConstants() throws Exception{
		/*List<SysConstant> constants = this.sysDefaultService.findConstants();
		System.out.println(Arrays.toString(constants.toArray()));
		constants = this.sysDefaultService.findConstantsByLevel(1);
		System.out.println(Arrays.toString(constants.toArray()));
		constants = this.sysDefaultService.findConstantsByParentCode("900000");
		System.out.println(Arrays.toString(constants.toArray()));*/
		System.out.println(Arrays.toString(this.sysDefaultService.findConstantsByPage(null, 1).getResultSet().toArray()));
	}

	@Test
	public void testSelectOneConstant() throws Exception{
		System.out.println(this.sysDefaultService.selectOneConstant("200000")._shortDesc());
	}

	@Test
	public void insertOneConstant() throws Exception{
		SysConstant parent = this.sysDefaultService.selectOneConstant("501000");
		//
/*		SysConstant constant = new SysConstant();
		constant.setConstantName("新浪微博");
		constant.setConstantLevel(EntityConstants.CONSTANT_LEVEL_OPTION);
		constant.setParentCode(parent.getConstantCode());
		constant.setParentName(parent.getConstantName());
		System.out.println(constant.toString());
		this.sysDefaultService.insertOneConstant(constant);
		System.out.println(constant.toString());
		//
		constant = new SysConstant();
		constant.setConstantName("腾讯微博");
		constant.setConstantLevel(EntityConstants.CONSTANT_LEVEL_OPTION);
		constant.setParentCode(parent.getConstantCode());
		constant.setParentName(parent.getConstantName());
		System.out.println(constant.toString());
		this.sysDefaultService.insertOneConstant(constant);
		System.out.println(constant.toString());
		//
		constant = new SysConstant();
		constant.setConstantName("网易微博");
		constant.setConstantLevel(EntityConstants.CONSTANT_LEVEL_OPTION);
		constant.setParentCode(parent.getConstantCode());
		constant.setParentName(parent.getConstantName());
		System.out.println(constant.toString());
		this.sysDefaultService.insertOneConstant(constant);
		System.out.println(constant.toString());
		//
		constant = new SysConstant();
		constant.setConstantName("搜狐微博");
		constant.setConstantLevel(EntityConstants.CONSTANT_LEVEL_OPTION);
		constant.setParentCode(parent.getConstantCode());
		constant.setParentName(parent.getConstantName());
		System.out.println(constant.toString());
		this.sysDefaultService.insertOneConstant(constant);
		System.out.println(constant.toString());*/
	}

}
