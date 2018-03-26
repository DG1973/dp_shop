package dp.shop.Entity;

import java.util.Date;

//��Ʒ���
public class Category {
	private Integer id;				//id
	private Integer parent_id;	//1.�����id,��parent_id=0ʱ˵���Ǹ��ڵ�,һ�����
	private String name;			//2.�������
	private Integer status;		//3.���״̬1-����,2-�Ѿ�����
	private Integer sort_order;	//4.������,ͬ��չʾ˳��,��ֵ�������Ȼ����
	private Date create_time;	//5.����ʱ��
	private Date update_time;//6.����ʱ��
	
	public Category(Integer id, Integer parent_id, String name, Integer status, Integer sort_order, Date create_time,
			Date update_time) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.status = status;
		this.sort_order = sort_order;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public Category() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSort_order() {
		return sort_order;
	}

	public void setSort_order(Integer sort_order) {
		this.sort_order = sort_order;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", parent_id=" + parent_id + ", name=" + name + ", status=" + status
				+ ", sort_order=" + sort_order + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
	
	
	
}
