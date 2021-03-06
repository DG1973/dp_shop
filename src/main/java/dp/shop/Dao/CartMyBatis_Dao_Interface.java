package dp.shop.Dao;

import java.util.List;
import dp.shop.Entity.Cart;
import dp.shop.Entity.PageModel;

public interface CartMyBatis_Dao_Interface {
	
	/**
	 *1. 查询购物车
	 * 分页查询
	 * @param pageNo 页数
	 * @param pageSize 一页的条数
	 * @param userid 用户id
	 * @return PageModel
	 * */
	PageModel<Cart> findUserCart(Integer pageNo,Integer pageSize,Integer userid);
	
	
	/**
	 * 
	 *2.购物车添加商品
	 * @param userid 用户id
	 * @param cart 购物车
	 * @return int
	 * */
	int addUserCart(Integer userid,Cart cart);
	
	
	/**
	 * 
	 * 3.用户修改购物车中的商品数量
	 * @param userid 用户id
	 * @param product_id 需要修改的商品id
	 * @return int
	 * * */
	int updataUserCartByUseridAndProduct_id(Integer userid,Integer product_id,Integer quantity);
	int pd(Integer userid,Integer product_id);
	
	
	/**
	 * 4.移除购物车某个产品
	 * @param userid 用户ID
	 * @param product_id 需要移除商品id
	 * @return int
	 * * */
	int deletUserCartByUseridAndProduct_id(Integer userid,Integer product_id);
	
	
	/**
	 * 
	 * 5、6.购物车选中某个产品/ 购物车取消选中某个产品
	 * @param userid 用户ID
	 * @param product_id 需要选中/取消选中的商品id
	 * @param checked 是否选中：1为选中，0为未选中
	 * @return int
	 * */
	int updataUserCartCheckedByUseridAndProduct_id(Integer userid,Integer product_id,Integer checked);

	/**
	 * 7.查询购物车里的产品数量
	 * @param userid 用户ID
	 * 
	 * */
	
	List<Cart> findAllUserCart(Integer userid);
	/**
	 * 查询购物车中被勾选商品的总数
	 * */
	int findUserCartdequantity(Integer userid);
	
	/**
	 * 8、9.购物车全选/ 购物车取消全选
	 * 
	 * */
	
	int updataAllUserCartCheckedByUserid(Integer userid,Integer checked);
	
	/**
	 * 查询用户购物车中已选择的商品
	 * 
	 * 
	 * */
	
	List<Cart> findCartListByUserid(Integer userid);
	
}
