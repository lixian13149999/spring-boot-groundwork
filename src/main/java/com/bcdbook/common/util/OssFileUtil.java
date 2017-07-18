//package com.bcdbook.common.util;
//
//import com.aliyun.oss.OSSClient;
//import com.aliyun.oss.model.GeneratePresignedUrlRequest;
//import com.aliyun.oss.model.OSSObject;
//import com.aliyun.oss.model.ObjectMetadata;
//import com.aliyun.oss.model.PutObjectResult;
//import com.spibao.spring.common.domain.OssFinal;
//import com.spibao.spring.common.enums.GlobalExceptionEnum;
//import com.spibao.spring.common.exception.GlobalException;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import javax.imageio.ImageReadParam;
//import javax.imageio.ImageReader;
//import javax.imageio.stream.ImageInputStream;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.Date;
//import java.util.Iterator;
//
///**
// * Created by lason on 2017/3/19.
// * 阿里云文件服务器上传文件的公共方法
// */
//public class OssFileUtil {
//
//    /**
//     * 文件服务器加密值的id
//     */
//    public static  String ACCESS_KEY_ID  = OssFinal.ACCESS_KEY_ID;
//    /**
//     * 文件服务器加密值的具体值
//     */
//    public static  String  ACCESS_KEY_SECRET = OssFinal.ACCESS_KEY_SECRET;
//    /**
//     * 存储的服务器引擎,
//     * 引擎的设定与服务器的地址有关
//     */
//    public static  String  ENDPOINT = OssFinal.ENDPOINT;
//    /**
//     * 服务器的空间名字
//     */
//    public static  String  BUCKETNAME = OssFinal.BUCKETNAME;
//    /**
//     * TODO --这个还不知道是什么意思
//     */
//    public static  String  BUCKETNAME_VIDEO = OssFinal.BUCKETNAME_VIDEO;
//    /**
//     * 设定连接的等待时间
//     */
//    public static String OUT_OF_DATE = OssFinal.OUT_OF_DATE;
//
//    /**
//     * 定义一个Oss客户端
//     */
//    private static OSSClient client  = null;
//    /**
//     * 定义一个元数据对象
//     */
//    private static ObjectMetadata meta = null;
//
//
//    /**
//     * 初始化方法
//     */
//    public static void init(){
//        // 初始化一个OSSClient
//        client = new OSSClient(ENDPOINT,ACCESS_KEY_ID, ACCESS_KEY_SECRET);
//        meta = new ObjectMetadata();
//    }
//
//    //截取图片并上传
//    /**
//     * jpg图片格式
//     */
//    private static final String IMAGE_FORM_OF_JPG = "jpg";
//    /**
//     * png图片格式
//     */
//    private static final String IMAGE_FORM_OF_PNG = "png";
//
//
//    /**
//     * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
//     * 参数：formatName - 包含非正式格式名称 .（例如 "jpeg" 或 "tiff"）等 。
//     *
//     * @param postFix
//     *            文件的后缀名
//     * @return
//     */
//    public static Iterator<ImageReader> getImageReadersByFormatName(String postFix) {
//        switch (postFix.toLowerCase()) {
//        case IMAGE_FORM_OF_JPG:
//            return ImageIO.getImageReadersByFormatName(IMAGE_FORM_OF_JPG);
//        case IMAGE_FORM_OF_PNG:
//            return ImageIO.getImageReadersByFormatName(IMAGE_FORM_OF_PNG);
//        default:
//            return ImageIO.getImageReadersByFormatName(IMAGE_FORM_OF_JPG);
//        }
//    }
//
//
//
//    /**
//     * @Description: 上传文件到OSS文件服务器
//     * @param multipartFile 富文件对象
//     * @throws Exception
//     * @ReturnType:String   OSSObject的ETag值。
//     */
//    public static String  uploadFile(MultipartFile multipartFile, int width, int height, int left, int top) throws Exception{
//        //检测传入的富文件是否为空,如果为空则抛出参数为空的异常
//        if(multipartFile.isEmpty())
//            throw new GlobalException(GlobalExceptionEnum.PARAMETER_IS_NULL);
//
//        //获取文件的原名称
//        String sourceFileName = multipartFile.getOriginalFilename();
//        //获取文件的类型(后缀名)
//        String fileType = sourceFileName.substring(sourceFileName.lastIndexOf(".")+1, sourceFileName.length());
//        if(!"jpg".equalsIgnoreCase(fileType)&&!"png".equalsIgnoreCase(fileType)){
//        	return "false";
//        }
//        //用id生成器生成一个文件的key
//        String id = IdGen.uuid();
//        /*
//         * key可以拼路径，如"/solar-spring-boot/"+id
//         */
//        String key="agricultural/"+id;
//        //获取文件的文件流
//        InputStream inputStream = multipartFile.getInputStream();
//
//        ImageInputStream iis = null;
//        //截取图片
//        /*
//         * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
//         * 参数：formatName - 包含非正式格式名称 .（例如 "jpeg" 或 "tiff"）等 。
//         */
//        Iterator<ImageReader> it = getImageReadersByFormatName(fileType);
//
//        ImageReader reader = it.next();
//        // 获取图片流
//        iis = ImageIO.createImageInputStream(inputStream);
//
//        /*
//         * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
//         * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
//         */
//        reader.setInput(iis, true);
//
//        /*
//         * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
//         * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
//         * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
//         */
//        ImageReadParam param = reader.getDefaultReadParam();
//
//        /*
//         * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
//         * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
//         */
//        Rectangle rect = new Rectangle(left, top, width, height);
//
//        // 提供一个 BufferedImage，将其用作解码像素数据的目标。
//        param.setSourceRegion(rect);
//        /*
//         * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
//         * BufferedImage 返回。
//         */
//        BufferedImage bi = reader.read(0, param);
//        //将BufferedImage转为InputStream
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        ImageIO.write(bi, fileType, os);
//        InputStream is = new ByteArrayInputStream(os.toByteArray());
//        //进行初始化
//        init();
//        // 必须设置ContentLength
//        meta.setContentType(fileType);
//        // 上传Object.
//        PutObjectResult result = client.putObject(BUCKETNAME, key, is, meta);
//
//        return key;
//    }
//
//
//
//
//    /**
//     * @Description: 上传文件到OSS文件服务器
//     * @param multipartFile 富文件对象
//     * @throws Exception
//     * @ReturnType:String   OSSObject的ETag值。
//     */
//    public static String  uploadFile(MultipartFile multipartFile) throws Exception{
//        //检测传入的富文件是否为空,如果为空则抛出参数为空的异常
//        if(multipartFile.isEmpty())
//            throw new GlobalException(GlobalExceptionEnum.PARAMETER_IS_NULL);
//
//        //获取文件的原名称
//        String sourceFileName = multipartFile.getOriginalFilename();
//        //获取文件的类型(后缀名)
//        String fileType = sourceFileName.substring(sourceFileName.lastIndexOf(".")+1, sourceFileName.length());
//        //用id生成器生成一个文件的key
//        String id = IdGen.uuid();
//        /*
//         * key可以拼路径，如"/solar-spring-boot/"+id
//         */
//        String key="agricultural/"+id;
//        //获取文件的文件流
//        InputStream inputStream = multipartFile.getInputStream();
//
//        //进行初始化
//        init();
//        // 必须设置ContentLength
//        meta.setContentType(fileType);
//        // 上传Object.
//        PutObjectResult result = client.putObject(BUCKETNAME, key, inputStream, meta);
//
//        return key;
//    }
//
//    /**
//     * 根据文件的key获取其访问地址的方法
//     * @param key
//     * @return
//     */
//    public static String getFileURL(String key){
//        //初始化
//        init();
//
//        //设定文件的有效期,设定为30000毫秒(30秒)
//        Date expires = new Date (new Date().getTime() + Integer.parseInt(OUT_OF_DATE));
//
//        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(BUCKETNAME, key);
////        if(key.startsWith("msplatform")){
////            generatePresignedUrlRequest = new GeneratePresignedUrlRequest(BUCKETNAME, key);
////        }else {
////            generatePresignedUrlRequest = new GeneratePresignedUrlRequest(BUCKETNAME_VIDEO, key);
////        }
//        //设定文件地址的访问有效期
//        generatePresignedUrlRequest.setExpiration(expires);
//        //获取文件的访问地址
//        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
//
//        return url.toString();
//    }
//
//    /**
//     * @Description: 根据key获取oss服务器文件
//     * @param key
//     * @return
//     * @ReturnType:InputStream
//     */
//    public static InputStream  getObject(String key){
//        //初始化
//        init();
//
//        //定义返回值对象
//        OSSObject object = null;
//
//        if(key.startsWith("msplatform")){
//            object= client.getObject(BUCKETNAME, key);
//        }else{
//            object= client.getObject(BUCKETNAME_VIDEO, key);
//        }
//        object.getObjectMetadata().getContentType();
//        // 获取Object的输入流
//        InputStream objectContent = object.getObjectContent();
//
//        return objectContent;
//    }
//
//
//    /**
//     * @Description:删除文件
//     * @param key  OSS文件服务器上文件的唯一标识
//     * @ReturnType:void
//     */
//    public static void deleteFile(String key){
//        init();
//        client.deleteObject(BUCKETNAME, key);
//    }
//
//}
