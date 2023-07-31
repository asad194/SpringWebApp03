package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.sevencolumns.entity.HeadLine;
import com.example.demo.sevencolumns.entity.SevenColumns;
import com.example.demo.sevencolumns.repository.HeadLineDaoImpl;
import com.example.demo.sevencolumns.repository.SevenColumnsDaoImpl;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserDaoImpl;

@Controller
public class WebAppController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
		
	@PostMapping("/login")
	public ModelAndView login(@RequestParam("user_id") int userId, @RequestParam("password") String userPass) {
		//JdbcTemplate jdbcTemplate = new JdbcTemplate();
		DataSource dataSource = DataSourceBuilder.create().url("jdbc:h2:mem:test").driverClassName("org.h2.Driver").username("sa").password("").build();
		UserDaoImpl userDaoImpl = new UserDaoImpl(dataSource);
		User loginUser = userDaoImpl.searchUser(userId, userPass);
		if( loginUser.getUserName() != null ) {
			ModelAndView modelAndView = new ModelAndView("list.html");
			modelAndView.addObject("user", loginUser);
			/*
			 * リスト取得処理
			 */
			HeadLineDaoImpl headLineDaoImpl = new HeadLineDaoImpl(dataSource);
			List<HeadLine> headLines = headLineDaoImpl.getHeadLine(userId);
			modelAndView.addObject("headLine", headLines);

			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("login.html");
			modelAndView.addObject("user", loginUser);
			return modelAndView;
		}
		
	}
		
	@GetMapping("/list")
	public String list() {
		return "list";
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(Integer columnId, User loginUser) {
		// Dao呼び出し→返ってきたものをdetailへ
		DataSource dataSource = DataSourceBuilder.create().url("jdbc:h2:mem:test").driverClassName("org.h2.Driver").username("sa").password("").build();
		SevenColumnsDaoImpl sevenColumnsDaoImpl = new SevenColumnsDaoImpl(dataSource);
		SevenColumns detailColumns = sevenColumnsDaoImpl.getDetail(columnId);
		
		ModelAndView modelAndView = new ModelAndView("detail.html");
		modelAndView.addObject("columns", detailColumns);
		modelAndView.addObject("user", loginUser);
		return modelAndView;
	}
	
	@GetMapping("/input")
	public ModelAndView input(User loginUser, ColumnForm columnForm) {
		ModelAndView modelAndView = new ModelAndView("input.html");
		modelAndView.addObject("user", loginUser);
		SevenColumns column = new SevenColumns();
		modelAndView.addObject("column", column);
		return modelAndView;
	}
	
	@PostMapping("/input")
	public String checkColumnForm(@Validated ColumnForm columnForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "input";
		}
		return "list";
	}
	
	
}
