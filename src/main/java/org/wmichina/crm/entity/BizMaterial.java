package org.wmichina.crm.entity;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class BizMaterial {
	private String action="new";
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
    private Integer materialId;

    @Size(min=4,max=50,message="资料编号长度应在4位到50位之间.")
    private String materialCode;

    @Size(min=4,max=50,message="资料名称长度应在4位到50位之间.")
    private String materialName;

    @NotEmpty(message="资料主类不能为空.")
    private String materialCategory;

    @NotEmpty(message="资料分类不能为空.")
    private String materialClass;

    @NotEmpty(message="资料级别不能为空.")
    private String materialType;

    @NotEmpty(message="资料价格不能为空.")
    @DecimalMin(value="0",message="资料价格必须大于0")
    private Double materialPrice;

    private Double discount1;

    private String discountReason1;

    private Double discount2;

    private String discountReason2;

    private Double discount3;

    private String discountReason3;

    private Double discount4;

    private String discountReason4;

    private Double discount5;

    private String discountReason5;

    private Integer isValid;

    private Integer isOnsale;

    private Integer stock;

    private Date onDate;

    private Date offDate;

    private String remark;

    private Date createDate;

    private String createUser;

    private Date updateDate;

    private String updateUser;

    private byte[] description;

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(String materialCategory) {
        this.materialCategory = materialCategory;
    }

    public String getMaterialClass() {
        return materialClass;
    }

    public void setMaterialClass(String materialClass) {
        this.materialClass = materialClass;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Double getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(Double materialPrice) {
        this.materialPrice = materialPrice;
    }

    public Double getDiscount1() {
        return discount1;
    }

    public void setDiscount1(Double discount1) {
        this.discount1 = discount1;
    }

    public String getDiscountReason1() {
        return discountReason1;
    }

    public void setDiscountReason1(String discountReason1) {
        this.discountReason1 = discountReason1;
    }

    public Double getDiscount2() {
        return discount2;
    }

    public void setDiscount2(Double discount2) {
        this.discount2 = discount2;
    }

    public String getDiscountReason2() {
        return discountReason2;
    }

    public void setDiscountReason2(String discountReason2) {
        this.discountReason2 = discountReason2;
    }

    public Double getDiscount3() {
        return discount3;
    }

    public void setDiscount3(Double discount3) {
        this.discount3 = discount3;
    }

    public String getDiscountReason3() {
        return discountReason3;
    }

    public void setDiscountReason3(String discountReason3) {
        this.discountReason3 = discountReason3;
    }

    public Double getDiscount4() {
        return discount4;
    }

    public void setDiscount4(Double discount4) {
        this.discount4 = discount4;
    }

    public String getDiscountReason4() {
        return discountReason4;
    }

    public void setDiscountReason4(String discountReason4) {
        this.discountReason4 = discountReason4;
    }

    public Double getDiscount5() {
        return discount5;
    }

    public void setDiscount5(Double discount5) {
        this.discount5 = discount5;
    }

    public String getDiscountReason5() {
        return discountReason5;
    }

    public void setDiscountReason5(String discountReason5) {
        this.discountReason5 = discountReason5;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getIsOnsale() {
        return isOnsale;
    }

    public void setIsOnsale(Integer isOnsale) {
        this.isOnsale = isOnsale;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public Date getOffDate() {
        return offDate;
    }

    public void setOffDate(Date offDate) {
        this.offDate = offDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }
}