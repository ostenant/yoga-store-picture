package org.ostenant.yoga.store.webservice;

public interface DirMaker {

	/**
	 * 返回完整目录
	 * 
	 * @param root
	 *            根目�?
	 * @param children
	 *            子目�?
	 * @throws
	 */
	public String makeDir(String root, String children);

	/**
	 * @Title: deleteImage <br>
	 * @Description:删除文件 <br>
	 * @param @param imagePath
	 * @param @return    设定文件 <br>
	 * @return boolean    返回类型   <br>
	 * @throws
	 */
	public boolean deleteImage(String imagePath);

}
