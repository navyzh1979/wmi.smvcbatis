
package org.wmichina.crm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.wmichina.crm.entity.SysRight;
import org.wmichina.crm.service.SysRoleUserService;

@Controller
@RemoteProxy(name = "sysRightController")
public class DwrSysRightController {

	@Resource(name = "sysRoleUserService")
	private SysRoleUserService sysRoleUserService;

	@RemoteMethod
	public String showRight(Integer id) {
		List<SysRight> sysRights = this.sysRoleUserService.findRights();
		StringBuilder builder = new StringBuilder();
		
		for(SysRight sysRight:sysRights){
			builder.append(sysRight.getRightCode());
			builder.append("--");
			builder.append(sysRight.getRightName());
			builder.append("\n");
		}
		return builder.toString();
	}

}