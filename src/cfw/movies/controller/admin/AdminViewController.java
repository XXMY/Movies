package cfw.movies.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This controller is used to display the views,
 * due to the AngularJs and AJAX request method.
 * @author Fangwei_Cai
 * @time since 2016年3月24日 下午7:25:59
 */

@Controller
@RequestMapping("/admin")
public class AdminViewController {
	
	/**
	 * Show the management page.
	 * @author Fangwei_Cai
	 * @time since 2016年3月24日 下午7:31:59
	 */
	@RequestMapping("/manage")
	public String manageView(){
		return "/manage";
	}
	
	/**
	 * Show the userCenter page.
	 * @author Fangwei_Cai
	 * @time since 2016年3月24日 下午7:32:46
	 */
	@RequestMapping("/userCenter")
	public String userCenterView(){
		return "/userCenter";
	}
	
	/**
	 * Show the movies page.
	 * @author Fangwei_Cai
	 * @time since 2016年3月24日 下午7:34:18
	 */
	@RequestMapping("/movies")
	public String moviesView(){
		return "/movies";
	}
	
	/**
	 * Show the movie details page.
	 * @author Fangwei_Cai
	 * @time since 2016年3月24日 下午7:34:36
	 */
	@RequestMapping("/details")
	public String detailsView(){
		return "/details";
	}
	
	/**
	 * Show the movies edit page.
	 * @author Fangwei_Cai
	 * @time since 2016年3月24日 下午7:39:37
	 */
	@RequestMapping("/edit")
	public String movieEditView(){
		return "/edit";
	}
	
	/**
	 * Show the movies types page.
	 * @author Fangwei_Cai
	 * @time since 2016年3月29日 上午9:53:08
	 */
	@RequestMapping("/types")
	public String moviesTypeView(){
		return "/types";
	}
}
