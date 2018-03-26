package dp.shop.Dao;

import java.util.List;

import dp.shop.Entity.Category;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.Product;

public interface Shop_Dao_Interface {

	/**
	 * 查询所有商品类别
	 * */
	public List<Category> findAllCategory();
	/**
	 * 根据商品类别编号删除商品类别
	 * */
	public  int  deleteCategoryById(Integer Id);	
	/**
	 * 查询所有商品
	 * */
	public List<Product> findAllProduct();
	/**
	 * 根据商品编号删除商品
	 * */
	public  int  deleteProductById(Integer Id);
	
	/**
	 * 添加商品类别
	 * */
	public  int  addCategory(Category category);
	/**
	 * 添加商品
	 * */
	public  int  addProduct(Product product);
	/**
	 * 根据id查询商品类别
	 * */
	public Category findCategoryById(Integer id);
	/**
	 * 根据id修改商品类别
	 * */
	public int  updateCategory(Category category);
	/**
	 * 根据id查询商品信息
	 * */
	public Product findProductById(Integer id);
	/**
	 * 根据id修改商品信息
	 * */
	public int  updateProduct(Product product);
	/**
	 * 分页获取数据
	 * pageNo:获取第几页
	 * pageSize:每页有多少条数据
	 * 
	 * */
	public  PageModel<Product>findProductByPage(int pageNo,int pageSize);
	
	public  PageModel<Category>findCategoryByPage(int pageNo,int pageSize);
	
	
	public Integer findProductQuantity(Integer product_id);
}
