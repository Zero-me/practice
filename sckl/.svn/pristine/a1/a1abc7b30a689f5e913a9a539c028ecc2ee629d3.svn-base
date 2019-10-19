package response;

import java.io.Serializable;

/**
 * 
 * @author liuyingying
 *
 */
public class CommonReturnType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private String dealcode;
	
	private Object data;
	
	public static CommonReturnType create(Object data) {
		return CommonReturnType.create("success",data);
	}
	
	public static CommonReturnType create(String dealcode, Object data) {
		CommonReturnType res = new CommonReturnType();
		res.setDealcode(dealcode);
		res.setData(data);
		return res;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getDealcode() {
		return dealcode;
	}
	public void setDealcode(String dealcode) {
		this.dealcode = dealcode;
	}

	@Override
	public String toString() {
		return "CommonReturnType [dealcode=" + dealcode + ", data=" + data + "]";
	}
	
	
	
}
