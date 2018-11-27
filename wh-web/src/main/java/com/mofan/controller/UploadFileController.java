package com.mofan.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.mofan.bean.ResponseVO;
import com.mofan.enums.FilePathConstant;
import com.mofan.enums.ResponseConstant;
import com.mofan.util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * 
 * @ClassName:  UploadFileController   
 * @Description:上传文件Controller
 * @author:  MOFAN889
 * @date:   2018年11月21日 上午8:38:37   
 *
 */
@RestController
@RequestMapping("/dream/file")
@Api(value="文件上传CONTROLLER")
public class UploadFileController extends BaseController{

	@Value("${nas.file.path}")
	private String nasPath;
	
	/**
	 * 
	 * @Title: uploadFile   
	 * @Description: 上传文件
	 * @param: @param multipartFile
	 * @param: @return      
	 * @return: ResponseVO      
	 * @throws
	 */
	@ApiOperation(value="上传文件接口",notes="上传文件接口")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value="/uploadFile",method= RequestMethod.POST, headers = "content-type=multipart/form-data")
	public ResponseVO uploadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="file",required=true) MultipartFile multipartFile) {
		ResponseVO vo = new ResponseVO();
		try {
			if(multipartFile!=null) {
				String name = multipartFile.getName();
				String originalFilename = multipartFile.getOriginalFilename();
				String fileSuffix = FileUtil.getFileSuffix(originalFilename);
				FilePathConstant fileType =FileUtil.getFileType(fileSuffix);
				String fileParentPath = FileUtil.generateFilePath(nasPath,fileType.getDescription());
				if(!new File(fileParentPath).exists()) {
					new File(fileParentPath).mkdirs();
				}
				multipartFile.transferTo(new File(fileParentPath+File.separator+originalFilename));
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setResponseCode(ResponseConstant.FAIL.getCode());
			vo.setResponseMessage("上传文件失败");
		}
		
		return returnSuccessResult();
	
	}
}
