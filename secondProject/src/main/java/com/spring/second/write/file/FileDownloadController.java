package com.spring.second.write.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class FileDownloadController {

	private static final String IMAGE_PATH = "C:\\image";

	@RequestMapping("/download.do")
	public void download(@RequestParam("imageFileName") String imageFileName,
			@RequestParam("regNum") String regNum,
			HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = IMAGE_PATH + "\\" + regNum + "\\" + imageFileName;
		File file = new File(downFile);

		response.setHeader("Cache-control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+imageFileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		while(true) {
			int count = in.read(buffer);
			if(count == -1) {
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
}
