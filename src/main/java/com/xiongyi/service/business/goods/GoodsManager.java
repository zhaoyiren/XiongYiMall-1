package com.xiongyi.service.business.goods;

import java.util.List;
import com.xiongyi.entity.Page;
import com.xiongyi.util.PageData;

/** 
 * 璇存槑锛� 鍟嗗搧琛ㄦ帴鍙�
 * 鍒涘缓浜猴細XY 
 * 鍒涘缓鏃堕棿锛�2018-01-27
 * @version
 */
public interface GoodsManager{

	/**鏂板
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception;
	
	/**鍒犻櫎
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception;
	
	/**淇敼
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception;
	
	/**鍒楄〃
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
	/**鍒楄〃(鍏ㄩ儴)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll(PageData pd)throws Exception;
	
	/**閫氳繃id鑾峰彇鏁版嵁
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**鎵归噺鍒犻櫎
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;

	
}

