package org.packt.springboot22.vid01.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentController {
	
	@PostMapping(path = "/farm/legalDocument", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public String addLegalDoc(@RequestParam("document") MultipartFile legalDocument) {
	    return String.join("","Added document: ", legalDocument.getOriginalFilename());
	}

}
