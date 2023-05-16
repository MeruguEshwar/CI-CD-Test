package com.ojas.mvc.Controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ojas.mvc.model.Product;
import com.ojas.mvc.service.ProductServiceImpl;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@RequestMapping("/loadForm")
	public String loadForm(Model model) {
		Product productInfo = new Product();
		model.addAttribute("product", productInfo);
		return "productDetails";
	}

	@RequestMapping("/register")
	public String handleForm(@ModelAttribute("product") Product pro, Model model) {
		int count = productServiceImpl.CreateProduct(pro);
		String msg = "";
		if (count != 0)
			msg = "Product Inserted SuccessFully";
		else
			msg = "Product Not Inserted";
		model.addAttribute("msg", msg);
		return "productDetails";
	}
	
	
	@RequestMapping("/viewrecords")
	public String viewAll(Model model)
	{
		List<Product> viewProducts = productServiceImpl.viewProduct();
		model.addAttribute("listProducts", viewProducts);
		return "view";
	}
}
