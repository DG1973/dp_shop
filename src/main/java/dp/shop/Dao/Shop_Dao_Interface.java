package dp.shop.Dao;

import java.util.List;

import dp.shop.Entity.Category;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.Product;

public interface Shop_Dao_Interface {

	/**
	 * ��ѯ������Ʒ���
	 * */
	public List<Category> findAllCategory();
	/**
	 * ������Ʒ�����ɾ����Ʒ���
	 * */
	public  int  deleteCategoryById(Integer Id);	
	/**
	 * ��ѯ������Ʒ
	 * */
	public List<Product> findAllProduct();
	/**
	 * ������Ʒ���ɾ����Ʒ
	 * */
	public  int  deleteProductById(Integer Id);
	
	/**
	 * �����Ʒ���
	 * */
	public  int  addCategory(Category category);
	/**
	 * �����Ʒ
	 * */
	public  int  addProduct(Product product);
	/**
	 * ����id��ѯ��Ʒ���
	 * */
	public Category findCategoryById(Integer id);
	/**
	 * ����id�޸���Ʒ���
	 * */
	public int  updateCategory(Category category);
	/**
	 * ����id��ѯ��Ʒ��Ϣ
	 * */
	public Product findProductById(Integer id);
	/**
	 * ����id�޸���Ʒ��Ϣ
	 * */
	public int  updateProduct(Product product);
	/**
	 * ��ҳ��ȡ����
	 * pageNo:��ȡ�ڼ�ҳ
	 * pageSize:ÿҳ�ж���������
	 * 
	 * */
	public  PageModel<Product>findProductByPage(int pageNo,int pageSize);
	
	public  PageModel<Category>findCategoryByPage(int pageNo,int pageSize);
	
	
	public Integer findProductQuantity(Integer product_id);
}
