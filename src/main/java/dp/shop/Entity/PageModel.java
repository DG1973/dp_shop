package dp.shop.Entity;
import java.util.List;

/**
 * ��ҳģ��
 * */
public class PageModel<T>{
	/**
	 * 
	 */
	//ÿһҳ���ݼ���
	private  List<T> data;
	//�ܹ��ж���ҳ
	private  int  totalPage;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}	
}
