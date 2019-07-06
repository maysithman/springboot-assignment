package com.techfun.assign_two.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.techfun.assign_two.model.Employee;
import com.techfun.assign_two.service.EmployeeService;

@Controller
public class MainController implements WebMvcConfigurer {

	@Autowired
	EmployeeService employeeService;

	private static List<Employee> employees = new ArrayList<Employee>();

	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		List<Employee> employees = employeeService.selectAllEmployee();
		model.addAttribute("employees", employees);
		return "index";
	}

	@GetMapping(value = { "/employee" })
	public String showAddEmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee";
	}

	@PostMapping(value = { "/employee" })
	public String saveEmployee(Model model, @ModelAttribute("employee") @Validated Employee emp, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "employee";
		}

		String name = emp.getName();
		Integer age = emp.getAge();
		String city = emp.getCity();
		String email = emp.getEmail();
		
		//Employee newEmployee = new Employee(name, age, city);
		Employee newEmployee = new Employee(name, age, city, email);
		employees.add(newEmployee);
		employeeService.createEmployee(newEmployee);
		
		return "redirect:/index";

	}

	@ModelAttribute("singleSelectAllValues")
	public String[] getSingleSelectAllValues() {
		return new String[] { "Yangon", "Mandalay", "Mawlamyaing", "Bago", "Mudon", "Thanbuyzayat", "Yay" };
	}

	@GetMapping(value = "/employee/deleteEmployee/{id}")
	public String deleteEmployee(@ModelAttribute("id") Integer id) throws Exception {
		employeeService.deleteEmployee(id);
		;
		return "redirect:/index";
	}

	@GetMapping(value = "/updateEmployee/{id}")
	public ModelAndView showUpdateEmployeeForm(@PathVariable("id") Integer id,
			@ModelAttribute("updateEmployee") Employee empoyee) {
		Employee emp = employeeService.findByEmployeeId(id);
		ModelAndView mav = new ModelAndView("employeeEdit");
		mav.addObject("updateEmployee", emp);
		return mav;
	}

	@PostMapping(value = "/updateEmployee")
	public String updateEmployee(@ModelAttribute("updateEmployee") Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:/index";
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCorsMappings(CorsRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFormatters(FormatterRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

}
