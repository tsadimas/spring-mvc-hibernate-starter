package gr.hua.dit.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTTPErrorHandler {

	@RequestMapping(value = "/400")
	public String error400(Model model) {
		model.addAttribute("errorMsg", "custom error handler 400");
		return "error";
	}

	@RequestMapping(value = "/404")
	public String error404(Model model) {
		model.addAttribute("errorMsg", "custom error handler 404");
		return "error";
	}
	@RequestMapping(value = "/403")
	public String error403(Model model) {
		model.addAttribute("errorMsg", "custom error handler 403");
		return "error";
	}

	@RequestMapping(value = "/500")
	public String error500(Model model) {
		model.addAttribute("errorMsg", "custom error handler 500");
		return "error";
	}
}