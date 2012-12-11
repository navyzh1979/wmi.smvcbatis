/**
 * 
 */
package org.wminchina.crm.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.wmichina.crm.entity.SysRight;

/**
 * action测试列子
 * @author fule
 *
 */
public class MVCUnitest extends MVCUnitestBase {
	
	@Test
	public void testUserShow() throws Exception{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setServletPath("/background/login.html");  
		
		final ModelAndView mav = this.excuteAction(request, response);
		List<SysRight> rights =(List<SysRight>) mav.getModelMap().get("result");

		System.out.println(Arrays.toString(rights.toArray()));
	}
}

