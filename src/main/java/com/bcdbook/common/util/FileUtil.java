package com.bcdbook.common.util;

import com.bcdbook.common.exception.GlobalException;
import com.bcdbook.common.exception.GlobalExceptionEnum;
import com.bcdbook.common.ifinal.FileFinal;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by lason on 2017/3/18.
 */
public class FileUtil {

    /**
     * 获取目标路径的方法
     * @param fileType
     * @return
     */
    public static String getRelativePath(String fileType){

        /**
         * 如果传入值为空,则抛出异常
         */
        if(StringUtils.isBlank(fileType))
            throw new GlobalException(GlobalExceptionEnum.PARAMETER_IS_NULL);

        /*
         * 创建目标路径,用于拼接返回的路径
         */
        StringBuilder targetPath = new StringBuilder();

        //获取系统时间的相关数据,用于动态生成文件夹的名称
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        /*
         * 拼接路径
         */
        targetPath.append("/");
        targetPath.append(FileFinal.FILE_DEFAULT_PATH);
        targetPath.append("/");
        targetPath.append(fileType);
        targetPath.append("/");
        targetPath.append(year);
        targetPath.append("/");
        targetPath.append(month);
        targetPath.append("/");
        targetPath.append(day);
        targetPath.append("/");
        //返回最后的结果
        return targetPath.toString();
    }

    /**
     * 根据源文件名获取文件类型的方法
     * @param sourceFileName
     * @return
     */
    public static String getFileType(String sourceFileName){
        if(StringUtils.isBlank(sourceFileName))
            return null;

        //获取文件的后缀
        return sourceFileName.substring(sourceFileName.lastIndexOf(".")+1, sourceFileName.length());
    }

    /**
     * 获取文件目标名称的方法
     * @param sourceFileName
     * @return
     */
    public static String getTargetName(String sourceFileName){
        /**
         * 如果传入值为空,则抛出异常
         */
        if(StringUtils.isBlank(sourceFileName))
            throw new GlobalException(GlobalExceptionEnum.PARAMETER_IS_NULL);

        /*
         * 创建builder对象,
         * 用于拼装返回的数据
         */
        StringBuilder targetName = new StringBuilder();

        //获取系统时间戳,用于充当文件的名字
        String targetFileName = DateUtil.getTimeStr(13);
        //获取文件的后缀
        String fileSuffix = sourceFileName.substring(sourceFileName.lastIndexOf("."), sourceFileName.length());

        /*
         * 拼接目标文件地址
         */
        targetName.append(targetFileName);
        targetName.append(fileSuffix);

        return targetName.toString();
    }

    /**
     * 获取目标路径和目标文件名的方法
     * @param fileType
     * @param sourceFileName
     * @return
     */
    public static String getRelativePathAndName(String fileType,String sourceFileName){
        /**
         * 如果传入值为空,则抛出异常
         */
        if(StringUtils.isBlank(fileType)
                ||StringUtils.isBlank(sourceFileName))
            throw new GlobalException(GlobalExceptionEnum.PARAMETER_IS_NULL);

        /*
         * 创建builder对象,
         * 用于拼装返回的数据
         */
        StringBuilder relativePathAndName = new StringBuilder();

        //获取目标相对路径
        String relativePath = getRelativePath(fileType);
        //获取目标文件的名称
        String targetName = getTargetName(sourceFileName);

        /*
         * 拼接目标文件地址
         */
        relativePathAndName.append(relativePath);
        relativePathAndName.append(targetName);

        return relativePathAndName.toString();
    }

    /**
     * 用于复制文件的方法,传入一个文件对象,
     * 返回存储到服务器后的一个相对路径
     * @param multipartFile
     * @return
     */
//    public static String copy(String relativePath,String targetPath,MultipartFile multipartFile) throws IOException {
//        //验证参数的合法性,如果参数为空,则抛出异常
//        if(StringUtils.isBlank(targetPath)
//                ||multipartFile.isEmpty())
//            throw new GlobalException(GlobalExceptionEnum.PARAMETER_IS_NULL);
//
//        //获取源文件的名字
//        String sourceFileName = multipartFile.getOriginalFilename();
//        if(StringUtils.isBlank(sourceFileName))
//            throw new GlobalException(GlobalExceptionEnum.PARAMETER_IS_NULL);
//
//        //获取项目的目标名字
//        String targetName = getTargetName(sourceFileName);
//
//        // 这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
//        // 此处也可以使用Spring提供的MultipartFile.transferTo(File,dest)方法实现文件的上传
//        //这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建
//        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),new File(targetPath, targetName));
//
////        return relativePath+targetName;
//        return targetName;
//    }

    /**
     * 用于复制文件的方法,传入一个文件对象,
     * 返回存储到服务器后的一个相对路径
     * @param multipartFile
     * @return
     */
    public static String copy(String relativePath,String targetPath,MultipartFile multipartFile) throws IOException {
        //验证参数的合法性,如果参数为空,则抛出异常
        if(StringUtils.isBlank(targetPath)
                ||multipartFile.isEmpty())
            throw new GlobalException(GlobalExceptionEnum.PARAMETER_IS_NULL);

        //获取源文件的名字
        String sourceFileName = multipartFile.getOriginalFilename();
        if(StringUtils.isBlank(sourceFileName))
            throw new GlobalException(GlobalExceptionEnum.PARAMETER_IS_NULL);

        //获取项目的目标名字
        String targetName = getTargetName(sourceFileName);

        // 这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
        // 此处也可以使用Spring提供的MultipartFile.transferTo(File,dest)方法实现文件的上传
        //这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),new File(targetPath+relativePath, targetName));

        return targetName;
    }

}
