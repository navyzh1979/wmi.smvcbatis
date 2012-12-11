/**
 * 
 */
package org.wmichina.crm.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.wmichina.crm.entity.SysRight;

/**
 * Created on 2012-11-2 下午3:12:35.
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
public class RightMenuBuilder implements Serializable {

	private static final long serialVersionUID = -8792534683669214593L;
	private static Logger log = Logger.getLogger(RightMenuBuilder.class);
	
	private List<RightMenu> mymenus = new ArrayList<RightMenu>();

	public List<RightMenu> getMymenus() {
		return mymenus;
	}

	public void addMymemu(RightMenu leftMen) {
		mymenus.add(leftMen);
	}
	
	public void setMymenus(List<RightMenu> mymenus) {
		this.mymenus = mymenus;
	}
	
	public static RightMenuBuilder initMymenus(List<SysRight> rights){
		RightMenuBuilder builder = new RightMenuBuilder();
		
		//#1. split rights to different MAP by rightLevel.
		Map<String, SysRight> branchMap = new HashMap<String, SysRight>();
		Map<String, List<SysRight>> nodeMap = new HashMap<String, List<SysRight>>();
		for(SysRight right : rights){
			if(EntityConstants.RIGHT_LEVEL_BRANCH == right.getRightLevel()){
				branchMap.put(right.getRightCode(), right);
			}else if(EntityConstants.RIGHT_LEVEL_NODE == right.getRightLevel()){
				List<SysRight> nodeRights = nodeMap.get(right.getParentRight())==null?
						(new ArrayList<SysRight>()):nodeMap.get(right.getParentRight());
				nodeRights.add(right);
				nodeMap.put(right.getParentRight(), nodeRights);
			}else {
				log.warn(right.toString() + " doesn't match level: branch, node.");
			}
		}
		
		//#2. create RightMenu by brandMap and nodeMap.
		for(Entry<String,SysRight> entry:branchMap.entrySet()){
			RightMenu leftMenu = new RightMenu();
			leftMenu.setBranchRight(entry.getValue());
			leftMenu.setNodeRights(nodeMap.get(entry.getKey()));
			
			builder.addMymemu(leftMenu);
		}
		
		return builder;
	}
	
}