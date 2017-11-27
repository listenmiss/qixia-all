package cn.com.catcher.vision.gov.qixia.approval.model;

public class Item {
private Integer id;
private Integer depart_id;
private String item_name;
private Integer item_state;
private Integer item_type1;
private Integer item_type2;
private Department department;


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getDepart_id() {
	return depart_id;
}
public void setDepart_id(Integer depart_id) {
	this.depart_id = depart_id;
}
public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public Integer getItem_state() {
	return item_state;
}
public void setItem_state(Integer item_state) {
	this.item_state = item_state;
}
public Integer getItem_type1() {
	return item_type1;
}
public void setItem_type1(Integer item_type1) {
	this.item_type1 = item_type1;
}
public Integer getItem_type2() {
	return item_type2;
}
public void setItem_type2(Integer item_type2) {
	this.item_type2 = item_type2;
}
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}



}
