package org.wmichina.crm.helper;

import java.util.List;

import org.wmichina.crm.entity.SysRight;


/**
 * 左侧功能菜单 - 功能模块项
 */
public class RightMenu{
	SysRight branchRight;
	List<SysRight> nodeRights;
	
	public SysRight getBranchRight() {
		return branchRight;
	}
	public void setBranchRight(SysRight branchRight) {
		this.branchRight = branchRight;
	}
	public List<SysRight> getNodeRights() {
		return nodeRights;
	}
	public void setNodeRights(List<SysRight> nodeRights) {
		this.nodeRights = nodeRights;
	}
	
	public String toString(){
		if(branchRight == null) return "{}";
		
		StringBuilder menuBuilder = new StringBuilder();
		menuBuilder.append("{").append(branchRight.getRightCode()).append("-").append(branchRight.getRightName());
		menuBuilder.append("[");
		for(SysRight nodeRight:nodeRights){
			menuBuilder.append(nodeRight._shortDesc()).append(",");
		}
		menuBuilder.append("]}");
				
		return menuBuilder.toString();
	}
}