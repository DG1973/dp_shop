package dp.shop.Service.Imp;

import java.util.List;

import dp.shop.Dao.Shop_Dao_Interface;
import dp.shop.Dao.Imp.Shop_Dao_Imp;
import dp.shop.Entity.Category;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.Product;
import dp.shop.Service.Shop_Service_Interface;

public class Shop_Service_Imp implements Shop_Service_Interface {
	private static  Shop_Service_Interface daoDanLi=null;
	private Shop_Service_Imp() {}
	public synchronized static Shop_Service_Interface getShopService() {
		if(daoDanLi==null) {
			return daoDanLi=new Shop_Service_Imp();
		}
		return daoDanLi;
	}
	@Override
	public List<Category> findAllCategory() {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.findAllCategory();
	}

	@Override
	public int deleteCategoryById(Integer Id) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.deleteCategoryById(Id);
	}

	@Override
	public List<Product> findAllProduct() {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.findAllProduct();
	}

	@Override
	public int deleteProductById(Integer Id) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.deleteProductById(Id);
	}

	@Override
	public int addCategory(Category category) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.addCategory(category);
	}

	@Override
	public int addProduct(Product product) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.addProduct(product);
	}

	@Override
	public Category findCategoryById(Integer id) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.findCategoryById(id);
	}

	@Override
	public int updateCategory(Category category) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.updateCategory(category);
	}

	@Override
	public Product findProductById(Integer id) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.findProductById(id);
	}

	@Override
	public int updateProduct(Product product) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.updateProduct(product);
	}

	@Override
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.findProductByPage(pageNo, pageSize);
	}

	@Override
	public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {
		Shop_Dao_Interface shop_dao_Imp=Shop_Dao_Imp.getShopDao();
		return shop_dao_Imp.findCategoryByPage(pageNo, pageSize);
	}

}
