package org.packt.springboot22.vid01.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebExceptionController implements ErrorController{
	
	@GetMapping("/error")
	@ExceptionHandler(value = NullPointerException.class)
	public String nullExceptionHandler(HttpServletResponse resp) {			
		
		if(resp.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			return "mst_farm_generic_500";
		} else if(resp.getStatus() == HttpStatus.NOT_FOUND.value()) {
			return "mst_farm_generic_404";
		}
		return "mst_farm_generic_404";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	

}
