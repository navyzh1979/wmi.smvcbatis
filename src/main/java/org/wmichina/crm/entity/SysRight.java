/**
 * 
 */
package org.wmichina.crm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

/**
 * Created on 2012-10-29 下午3:12:46.
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
public class SysRight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8210429525814709285L;

	private Integer rightId;
	private String rightCode;
	private String rightName;
	private String rightAbbr;
	private String rightURL;
	private Integer rightLevel;
	private String parentRight;
	private Integer isValid;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	private String remark;
	private List<SysRight> childRights = new ArrayList<SysRight>();
	
	public List<SysRight> getChildRights() {
		return childRights;
	}
	public void setChildRights(List<SysRight> childRights) {
		this.childRights = childRights;
	}
	public Integer getRightId() {
		return rightId;
	}
	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}
	public String getRightCode() {
		return rightCode;
	}
	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public String getRightAbbr() {
		return rightAbbr;
	}
	public void setRightAbbr(String rightAbbr) {
		this.rightAbbr = rightAbbr;
	}
	public String getRightURL() {
		return rightURL;
	}
	public void setRightURL(String rightURL) {
		this.rightURL = rightURL;
	}
	public Integer getRightLevel() {
		return rightLevel;
	}
	public void setRightLevel(Integer rightLevel) {
		this.rightLevel = rightLevel;
	}
	public String getParentRight() {
		return parentRight;
	}
	public void setParentRight(String parentRight) {
		this.parentRight = parentRight;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String _shortDesc(){
		return new StringBuilder()
				.append("(").append(this.rightCode).append(",").append(this.rightName)
				.append(",").append(this.rightLevel).append(",").append(this.parentRight)
				.append(")")
				.toString();
	}
	public String _middleDesc(){
		return new StringBuilder()
				.append("(").append(this.rightCode).append(",").append(this.rightName)
				.append(",").append(this.rightLevel).append(",").append(this.parentRight)
				.append(",").append(this.rightURL).append(",").append(this.rightId)
				.append(")")
				.toString();
	}
	
	@Override
	public String toString(){
		return new JSONObject(this).toString();
	}
	
}
