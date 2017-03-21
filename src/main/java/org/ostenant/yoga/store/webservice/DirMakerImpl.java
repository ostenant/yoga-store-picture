package org.ostenant.yoga.store.webservice;

import java.io.File;
import java.util.UUID;

import javax.jws.WebService;
import javax.servlet.ServletContext;

/**
 * 实现目录创建
 */
@WebService
public class DirMakerImpl implements DirMaker {

	private ServletContext sc;

	public DirMakerImpl() {
	}

	public DirMakerImpl(ServletContext sc) {
		this.sc = sc;
	}

	public String makeDir(String root, String children) {
		String dirFirst = sc.getRealPath(removefix(root));
		String dirSecond = getMultiFileDir();
		String realDir = dirFirst + "/" + dirSecond;
		if (!new File(realDir).exists()) {
			new File(realDir).mkdirs();
		}
		return removefix(root) + "/" + dirSecond + "/";
	}

	public static void main(String[] args) {
	}

	public static String removefix(String string) {
		if (string.endsWith("/")) {
			string = string.substring(0, string.length() - 1);
		}
		if (string.startsWith("/")) {
			string = string.substring(1);
		}
		return string;
	}

	/**
	 * @Title: getMultiFileDir <br>
	 * @Description: 返回多级文件目录 分目录存�? <br>
	 * @Author: madison <br>
	 * @param @return 设定文件 <br>
	 * @return String 返回类型 <br>
	 * @throws
	 */
	public static String getMultiFileDir() {
		// -- 设置分目录存�?
		StringBuilder sb = new StringBuilder();
		String uuid = UUID.randomUUID().toString();
		String hashcode = (uuid.hashCode() + "").replaceFirst("-", "");
		char[] charArray = hashcode.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (i > 0) {
				sb.append("/");
			}
			sb.append(charArray[i]);
		}
		return sb.toString();
	}

	public boolean deleteImage(String imagePath) {
		// 获取真是路径
		String path = this.sc.getRealPath(imagePath);
		System.out.println(path);
		// 删除文件
		File imageFile = new File(path);
		if (imageFile.exists()) {
			imageFile.delete();
			return true;
		}
		return false;
	}

}
