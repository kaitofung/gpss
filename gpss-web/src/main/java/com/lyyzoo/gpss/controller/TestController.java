package com.lyyzoo.gpss.controller;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.gpss.common.utils.IMappingParameter;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.BucketManager.FileListIterator;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

@Controller
@RequestMapping("/test")
public class TestController extends AbstractController implements IMappingParameter {
	private static String accessKey = "TZSXj2U6RjOANwHgMnFCC_w3gxbaTUBrQ0lZ4s6B";  
	private static String secretKey = "uc_YX5NqF3Y3-UYJjwu8Em1qqinZt39BH5olYByX";  
	private static String bucket = "kaitofung";  
	/** 
	 * 获取上传凭证 
	 */  
	public static String getUploadCredential() {  
	    Auth auth = Auth.create(accessKey, secretKey);  
	    String upToken = auth.uploadToken(bucket);  
	    System.out.println(upToken);  
	    return upToken;  
	}  
	  
	  
	/** 
	 * 文件上传 
	 * @param zone  
	 *    华东    Zone.zone0() 
	 *    华北    Zone.zone1() 
	 *    华南    Zone.zone2() 
	 *    北美    Zone.zoneNa0() 
	 * @param upToken 上传凭证 
	 * @param localFilePath 需要上传的文件本地路径 
	 * @return 
	 */  
	public static DefaultPutRet fileUpload(Zone zone,String upToken,String localFilePath) {  
	    // 构造一个带指定Zone对象的配置类  
	    Configuration cfg = new Configuration(zone);  
	    // ...其他参数参考类注释  
	    UploadManager uploadManager = new UploadManager(cfg);  
	    // 默认不指定key的情况下，以文件内容的hash值作为文件名  
	    String key = null;  
	    try {  
	        Response response = uploadManager.put(localFilePath, key, upToken);  
	        // 解析上传成功的结果  
	        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);  
	        System.out.println("fileUpload:  "+putRet.key);  
	        System.out.println(putRet.hash);  
	        return putRet;  
	    } catch (QiniuException ex) {  
	        Response r = ex.response;  
	        System.err.println(r.toString());  
	        try {  
	            System.err.println(r.bodyString());  
	        } catch (QiniuException ex2) {  
	            // ignore  
	        }  
	    }  
	    return null;  
	}  
	
	
	/** 
	 * 文件上传 
	 * @param zone  
	 *    华东    Zone.zone0() 
	 *    华北    Zone.zone1() 
	 *    华南    Zone.zone2() 
	 *    北美    Zone.zoneNa0() 
	 * @param upToken 上传凭证 
	 * @param localFilePath 需要上传的文件二进制流
	 * @return 
	 */  
	public static DefaultPutRet fileUpload(Zone zone,String upToken,InputStream inputStream) {  
		// 构造一个带指定Zone对象的配置类  
		Configuration cfg = new Configuration(zone);  
		// ...其他参数参考类注释  
		UploadManager uploadManager = new UploadManager(cfg);  
		// 默认不指定key的情况下，以文件内容的hash值作为文件名  
		String key = null;  
		try {  
			Response response = uploadManager.put(inputStream, key, upToken, null, null);
			// 解析上传成功的结果  
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);  
			System.out.println(putRet.key);  
			System.out.println(putRet.hash);  
			return putRet;  
		} catch (QiniuException ex) {  
			Response r = ex.response;  
			System.err.println(r.toString());  
			try {  
				System.err.println(r.bodyString());  
			} catch (QiniuException ex2) {  
				// ignore  
			}  
		}  
		return null;  
	}  
	
	public static Auth getAuth() {  
	    return Auth.create(accessKey, secretKey);  
	}  
	  
	/** 
	 * 公有空间返回文件URL 
	 * @param fileName 
	 * @param domainOfBucket 
	 * @return 
	 */  
	public static String publicFile(String fileName,String domainOfBucket) {  
	    String encodedFileName=null;  
	    try {  
	        encodedFileName = URLEncoder.encode(fileName, "utf-8");  
	    } catch (UnsupportedEncodingException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }  
	    String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);  
	    System.out.println(finalUrl);  
	    return finalUrl;  
	}  
	  
	/** 
	 * 私有空间返回文件URL 
	 * @param auth 
	 * @param fileName 
	 * @param domainOfBucket 
	 * @param expireInSeconds 
	 * @return 
	 */  
	public static String privateFile(Auth auth,String fileName,String domainOfBucket,long expireInSeconds) {  
	    String encodedFileName=null;  
	    try {  
	        encodedFileName = URLEncoder.encode(fileName, "utf-8");  
	    } catch (UnsupportedEncodingException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }  
	    String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);  
	    String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);  
	    System.out.println(finalUrl);  
	    return finalUrl;  
	}  
	
	/** 
	 * 获取文件信息 
	 * @param zone 节点值
	 * @param key 在空间中的文件命名
	 * @param auth 授权对象，可以通过getAuth方法取得
	 * @param bucket 空间名称
	 * @return 
	 */  
	public static FileInfo getFileInfo(Zone zone,String key,Auth auth,String bucket) {  
	    // 构造一个带指定Zone对象的配置类  
	    Configuration cfg = new Configuration(zone);  
	    BucketManager bucketManager = new BucketManager(auth, cfg);  
	    try {  
	        FileInfo fileInfo = bucketManager.stat(bucket, key);  
	        System.out.println(fileInfo.hash);  
	        System.out.println(fileInfo.fsize);  
	        System.out.println(fileInfo.mimeType);  
	        System.out.println(fileInfo.putTime);  
	        return fileInfo;  
	    } catch (QiniuException ex) {  
	        System.err.println(ex.response.toString());  
	    }  
	    return null;  
	}  
	
	/** 
	 * 修改文件类型 
	 * @param zone 
	 * @param key 
	 * @param auth 
	 * @param bucket 
	 * @param newMimeType 
	 */  
	public static void editFileType(Zone zone,String key,Auth auth,String bucket,String newMimeType) {  
	    // 构造一个带指定Zone对象的配置类  
	    Configuration cfg = new Configuration(zone);  
	    BucketManager bucketManager = new BucketManager(auth, cfg);  
	    // 修改文件类型  
	    try {  
	        bucketManager.changeMime(bucket, key, newMimeType);  
	    } catch (QiniuException ex) {  
	        System.out.println(ex.response.toString());  
	    }  
	}  
	
	
	/** 
	 * 移动文件 
	 * @param zone 
	 * @param auth 
	 * @param fromBucket 
	 * @param fromKey 
	 * @param toBucket 
	 * @param toKey 
	 */  
	public static boolean move(Zone zone,Auth auth,String fromBucket,String fromKey,String toBucket,String toKey) {  
	    // 构造一个带指定Zone对象的配置类  
	    Configuration cfg = new Configuration(zone);  
	    BucketManager bucketManager = new BucketManager(auth, cfg);  
	    try {  
	    	Response response = bucketManager.move(fromBucket, fromKey, toBucket, toKey);  
	    } catch (QiniuException ex) {  
	        // 如果遇到异常，说明移动失败  
	        System.err.println(ex.code());  
	        System.err.println(ex.response.toString());  
	        return false;
	    }  
	    return true;
	    
	}  
	
	/** 
	 * 复制文件 
	 * @param zone 
	 * @param auth 
	 * @param fromBucket 
	 * @param fromKey 
	 * @param toBucket 
	 * @param toKey 
	 */  
	public static boolean copy(Zone zone,Auth auth,String fromBucket,String fromKey,String toBucket,String toKey) {  
	    // 构造一个带指定Zone对象的配置类  
	    Configuration cfg = new Configuration(zone);  
	    BucketManager bucketManager = new BucketManager(auth, cfg);  
	    try {  
	        bucketManager.copy(fromBucket, fromKey, toBucket, toKey);  
	    } catch (QiniuException ex) {  
	        // 如果遇到异常，说明复制失败  
	        System.err.println(ex.code());  
	        return false;
	    }  
	    return true;
	}  
	
	/** 
	 * 刪除文件 
	 * @param key 
	 * @param auth 
	 * @param bucket 
	 */  
	public static boolean delete(Zone zone,String key,Auth auth,String bucket) {  
	    // 构造一个带指定Zone对象的配置类  
	    Configuration cfg = new Configuration(zone);  
	    BucketManager bucketManager = new BucketManager(auth, cfg);  
	    try {  
	        bucketManager.delete(bucket, key);  
	    } catch (QiniuException ex) {  
	        // 如果遇到异常，说明删除失败  
	        System.err.println(ex.code());  
	        System.err.println(ex.response.toString());  
	        return false;
	    }  
	    return true;
	}  
	
	/** 
	 * 设置文件生存时间 ，文件到了设置的天数会自动被删除
	 * @param zone 
	 * @param key 
	 * @param auth 
	 * @param bucket 
	 */  
	public static void setAliveTime(Zone zone,String key,Auth auth,String bucket,int days) {  
	    // 构造一个带指定Zone对象的配置类  
	    Configuration cfg = new Configuration(zone);  
	    BucketManager bucketManager = new BucketManager(auth, cfg);  
	    try {  
	        bucketManager.deleteAfterDays(bucket, key, days);  
	    } catch (QiniuException ex) {  
	        System.err.println(ex.response.toString());  
	    }  
	}  
	
	/** 
     * 获取文件列表 
     * @param zone 
     * @param auth   授权凭证 
     * @param bucket  存储空间名 
     * @param prefix  文件名前缀 
     * @param limit   每次迭代的长度限制，最大1000，推荐值 1000 
     * @param delimiter  指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串 
     * @return 
     */  
    public static FileListIterator getFileList(Zone zone,Auth auth,String bucket,String prefix,int limit,String delimiter) {  
        // 构造一个带指定Zone对象的配置类  
        Configuration cfg = new Configuration(zone);  
        BucketManager bucketManager = new BucketManager(auth, cfg);  
        // 列举空间文件列表  
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit,  
                delimiter);  
        while (fileListIterator.hasNext()) {  
            // 处理获取的file list结果  
            FileInfo[] items = fileListIterator.next();  
            for (FileInfo item : items) {  
                System.out.println(item.key);  
                System.out.println(item.hash);  
                System.out.println(item.fsize);  
                System.out.println(item.mimeType);  
                System.out.println(item.putTime);  
                System.out.println(item.endUser);  
            }  
        }  
        return fileListIterator;  
    }  
    
    /** 
     * 抓取网络资源到空间 
     * @param zone 
     * @param auth 
     * @param bucket 
     * @param key 
     * @param remoteSrcUrl 
     * @return 
     */  
    public static FetchRet fetchToSpace(Zone zone,Auth auth,String bucket,String key,String remoteSrcUrl) {  
        // 构造一个带指定Zone对象的配置类  
        Configuration cfg = new Configuration(zone);  
        //String remoteSrcUrl = "http://devtools.qiniu.com/qiniu.png";  
        BucketManager bucketManager = new BucketManager(auth, cfg);  
        // 抓取网络资源到空间  
        try {  
            FetchRet fetchRet = bucketManager.fetch(remoteSrcUrl, bucket, key);  
            System.out.println(fetchRet.hash);  
            System.out.println(fetchRet.key);  
            System.out.println(fetchRet.mimeType);  
            System.out.println(fetchRet.fsize);  
            return fetchRet;  
        } catch (QiniuException ex) {  
            System.err.println(ex.response.toString());  
        }  
        return null;  
    } 

	public static void main(String[] args) {
		//文件上传
		// fileUpload(Zone.zone2(),getUploadCredential(),"C:\\Users\\Administrator\\Desktop\\微信图片_20180919183113.png");  

		//文件外链生成
		//		System.err.println("xxx"+publicFile("Fqgx-cqVmKNdvMtigDxNKsLDfyCw", "oekcs3wuy.bkt.clouddn.com"));
//		System.err.println("xxx"+privateFile(getAuth(), "Fqgx-cqVmKNdvMtigDxNKsLDfyCw", "oekcs3wuy.bkt.clouddn.com", 66666));

		//获取文件信息
		//	System.err.println("xxx " + getFileInfo(Zone.zone2(), "Fqgx-cqVmKNdvMtigDxNKsLDfyCw", getAuth(), "kaitofung"));
	
		//文件改名
//	System.err.println(move(Zone.zone2(), getAuth(), "kaitofung", 
//			"xxx", "kaitofung", "aaa"));;
			
		//文件复制
//		System.err.println(copy(Zone.zone2(), getAuth(), "kaitofung", "神烦狗扮狼.jpg", "kaitofung", "xxxxxx"));
		
		//文件删除
//		System.err.println(delete(Zone.zone2(), "aaa", getAuth(), "kaitofung"));
		
		//获取空间中文件列表
//		System.err.println(getFileList(Zone.zone2(), getAuth(), "kaitofung", "Java", 2, ""));
	
		//把网络资源放到空间
		System.err.println(fetchToSpace(Zone.zone2(), getAuth(), "kaitofung", "jdk-10.0.2_linux-x64_bin.tar.gz", "http://download.oracle.com/otn-pub/java/jdk/10.0.2+13/19aef61b38124481863b1413dce1855f/jdk-10.0.2_linux-x64_bin.tar.gz"));
	}
}
