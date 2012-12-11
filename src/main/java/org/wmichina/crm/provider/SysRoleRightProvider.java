package org.wmichina.crm.provider;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.wmichina.crm.entity.SysRoleRight;

public class SysRoleRightProvider {
	
	/**
	 * 批量增加用户权限记录
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String batchInsertSysRoleRight(Map map) {  
        List<SysRoleRight> rights = (List<SysRoleRight>) map.get("list");  
        StringBuilder builder = new StringBuilder();  
        builder.append("INSERT INTO sys_role_rights(role_id,right_id) ");  
        builder.append("VALUES ");  
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].roleId}, #'{'list[{0}].rightId})");  
        for (int i = 0; i < rights.size(); i++) {  
        	builder.append(mf.format(new Object[]{i}));  
            if (i < rights.size() - 1) {  
            	builder.append(",");  
            }  
        }  
        System.out.println(builder.toString());
        return builder.toString();  
    }
	
}
