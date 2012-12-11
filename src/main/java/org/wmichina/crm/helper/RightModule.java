package org.wmichina.crm.helper;

import java.util.List;

import org.wmichina.crm.entity.SysRight;


/**
 * 权限模块展示 - 功能模块项
 */
public class RightModule{
	SysRight branchRight;
	List<SysRight> leafRights;
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
	public List<SysRight> getLeafRights() {
		return leafRights;
	}
	public void setLeafRights(List<SysRight> leafRights) {
		this.leafRights = leafRights;
	}
	
	public String toString(){
		if(branchRight == null) return "{}";
		
		StringBuilder menuBuilder = new StringBuilder();
		menuBuilder.append("{").append(branchRight.getRightCode()).append("-").append(branchRight.getRightName());
		menuBuilder.append("[nodes:");
		if(nodeRights!=null){
			for(SysRight nodeRight:nodeRights){
				menuBuilder.append(nodeRight._shortDesc()).append(",");

				menuBuilder.append("[n-leaf:");
				if(nodeRight.getChildRights()!=null){
					for(SysRight leafRight:nodeRight.getChildRights()){
						menuBuilder.append(leafRight._shortDesc()).append(",");
					}
				}
			}
		}
		menuBuilder.append("]-");
		menuBuilder.append("[b-leaf:");
		if(leafRights!=null){
			for(SysRight leafRight:leafRights){
				menuBuilder.append(leafRight._shortDesc()).append(",");
			}
		}
		menuBuilder.append("]}");
				
		return menuBuilder.toString();
	}
}