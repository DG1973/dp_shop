package dp.shop.Entity;

import java.math.BigDecimal;
import java.util.Date;

//商品
public class Product {
	private Integer id;						//商品id
	private Integer category_id;		//1.分类id,对应category表的主键	
	private String name;					//2.商品名称
	private String subtitle;				//3.商品副标题
	private String main_image;		//商品主图,url相对地址	
	private String sub_images;		//图片地址,json格式
	private String detail;					//4.商品详情		
	private BigDecimal price;			//5.价格,单位-元,保留两位小数,对应java类型BigDecimal
	private Integer stock;					//6.库存数量
	private Integer status;				//7.商品状态,1-在线 2-下架 3-删除
	private Date create_time;			//8.创建时间
	private Date update_time;		//9.更新时间
	
	public Product(Integer id, Integer category_id, String name, String subtitle, String main_image, String sub_images,
			String detail, BigDecimal price, Integer stock, Integer status, Date create_time, Date update_time) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.name = name;
		this.subtitle = subtitle;
		this.main_image = main_image;
		this.sub_images = sub_images;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public Product() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getMain_image() {
		return main_image;
	}

	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}

	public String getSub_images() {
		return sub_images;
	}

	public void setSub_images(String sub_images) {
		this.sub_images = sub_images;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		return "Product [id=" + id + ", category_id=" + category_id + ", name=" + name + ", subtitle=" + subtitle
				+ ", main_image=" + main_image + ", sub_images=" + sub_images + ", detail=" + detail + ", price="
				+ price + ", stock=" + stock + ", status=" + status + ", create_time=" + create_time + ", update_time="
				+ update_time + "]";
	}
	
	
	

}
