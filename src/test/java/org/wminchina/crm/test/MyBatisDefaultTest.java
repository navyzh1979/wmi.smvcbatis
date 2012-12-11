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
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
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
public class MyBatisDefaultTest extends org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests {
	

	@Resource(name = "sysDefaultService")
	private SysDefaultService sysDefaultService;
	
	@Test
	public void testQuery() throws Exception{
		//System.out.println(Arrays.toString(this.sysDefaultService.findRegionsByLevel(0).toArray()));
		System.out.println(this.sysDefaultService.selectOneRegion("0.000"));
	}

}
