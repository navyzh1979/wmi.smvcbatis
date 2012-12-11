package org.wmichina.crm.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.wmichina.crm.entity.SysRight;

public class RightModuleBuilder implements Serializable {
	//
	private static final long serialVersionUID = 5064081322346510505L;
	private static Logger log = Logger.getLogger(RightModuleBuilder.class);
	
	private List<RightModule> modules = new ArrayList<RightModule>();

	public void addRightModule(RightModule rightModule) {
		modules.add(rightModule);
	}
	
	public List<RightModule> getModules() {
		return modules;
	}

	public void setModules(List<RightModule> modules) {
		this.modules = modules;
	}

	public static RightModuleBuilder initModules(List<SysRight> rights){
		if (rights==null) return null;
		RightModuleBuilder builder = new RightModuleBuilder();
		
		//#1. split rights to different MAP by rightLevel.
		Map<String, SysRight> branchMap = new HashMap<String, SysRight>();
		Map<String, SysRight> nodeTmpMap = new HashMap<String, SysRight>();
		Map<String, List<SysRight>> nodeMap = new HashMap<String, List<SysRight>>();
		Map<String, List<SysRight>> leafMap = new HashMap<String, List<SysRight>>();
		for(SysRight right : rights){
			if(EntityConstants.RIGHT_LEVEL_BRANCH == right.getRightLevel()){
				branchMap.put(right.getRightCode(), right);
			}else if(EntityConstants.RIGHT_LEVEL_NODE == right.getRightLevel()){
				nodeTmpMap.put(right.getRightCode(), right);
			}else if(EntityConstants.RIGHT_LEVEL_LEAF == right.getRightLevel()){
				List<SysRight> leafRights = leafMap.get(right.getParentRight())==null?
						(new ArrayList<SysRight>()):leafMap.get(right.getParentRight());
				leafRights.add(right);
				System.out.println(right.getRightCode() + " add to map: " + right.getParentRight() +", list size: " + leafRights.size()); 
				leafMap.put(right.getParentRight(), leafRights);
			}else {
				log.warn(right.toString() + " doesn't match level: branch, node, leaf.");
			}
		}
		//#2. fill nodeMap.
		for(Entry<String,SysRight> entry:nodeTmpMap.entrySet()){
			SysRight nodeRight = entry.getValue();
			nodeRight.setChildRights(leafMap.get(entry.getKey()));

			List<SysRight> nodeRights = nodeMap.get(nodeRight.getParentRight())==null?
					(new ArrayList<SysRight>()):nodeMap.get(nodeRight.getParentRight());
			nodeRights.add(nodeRight);
			nodeMap.put(nodeRight.getParentRight(), nodeRights);
		}
		
		//#3. create RightModule by brandMap and nodeMap/leafMap.
		for(Entry<String,SysRight> entry:branchMap.entrySet()){
			RightModule rightModule = new RightModule();
			rightModule.setBranchRight(entry.getValue());
			rightModule.setNodeRights(nodeMap.get(entry.getKey()));
			rightModule.setLeafRights(leafMap.get(entry.getKey()));
			
			builder.addRightModule(rightModule);
			System.out.println(rightModule.toString());
		}

		return builder;
	}
	
}