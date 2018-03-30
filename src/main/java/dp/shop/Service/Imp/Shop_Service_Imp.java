package dp.shop.Service.Imp;

import java.util.List;

import dp.shop.Dao.Shop_Dao_Interface;
import dp.shop.Dao.Imp.Shop_Dao_Imp;
import dp.shop.Entity.Category;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.Product;
import dp.shop.Service.Shop_Service_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Shop_Service_Imp implements Shop_Service_Interface {
	@Autowired
	Shop_Dao_Interface shop_dao_Imp;

	public void setShop_dao_Imp(Shop_Dao_Interface shop_dao_Imp) {
		this.shop_dao_Imp = shop_dao_Imp;
	}

	@Override
	public List<Category> findAllCategory() {
		return shop_dao_Imp.findAllCategory();
	}

	@Override
	public int deleteCategoryById(Integer Id) {
		return shop_dao_Imp.deleteCategoryById(Id);
	}

	@Override
	public List<Product> findAllProduct() {

		return shop_dao_Imp.findAllProduct();
	}

	@Override
	public int deleteProductById(Integer Id) {

		return shop_dao_Imp.deleteProductById(Id);
	}

	@Override
	public int addCategory(Category category) {

		return shop_dao_Imp.addCategory(category);
	}

	@Override
	public int addProduct(Product product) {

		return shop_dao_Imp.addProduct(product);
	}

	@Override
	public Category findCategoryById(Integer id) {

		return shop_dao_Imp.findCategoryById(id);
	}

	@Override
	public int updateCategory(Category category) {

		return shop_dao_Imp.updateCategory(category);
	}

	@Override
	public Product findProductById(Integer id) {

		return shop_dao_Imp.findProductById(id);
	}

	@Override
	public int updateProduct(Product product) {

		return shop_dao_Imp.updateProduct(product);
	}

	@Override
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {

		return shop_dao_Imp.findProductByPage(pageNo, pageSize);
	}

	@Override
	public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {

		return shop_dao_Imp.findCategoryByPage(pageNo, pageSize);
	}

}
