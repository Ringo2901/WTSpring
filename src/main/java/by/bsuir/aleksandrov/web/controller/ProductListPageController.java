package by.bsuir.aleksandrov.web.controller;

import by.bsuir.aleksandrov.model.dao.PhoneDao;
import by.bsuir.aleksandrov.model.dao.impl.PhoneDaoImpl;
import by.bsuir.aleksandrov.model.entity.phone.Phone;
import by.bsuir.aleksandrov.model.entity.phone.sorting.SortField;
import by.bsuir.aleksandrov.model.entity.phone.sorting.SortOrder;
import by.bsuir.aleksandrov.model.utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/productList")
public class ProductListPageController {
    //@Autowired
    private PhoneDao phoneDao = new PhoneDaoImpl(HibernateSessionFactoryUtil.getSessionFactory());
   // @Resource
  //  private CartService cartService;

    private static final int PHONES_ON_PAGE = 10;

    @GetMapping
    public String showProductList(@RequestParam(name = "page", required = false) Integer pageNumber,
                                  @RequestParam(name = "sort", required = false) String sortField,
                                  @RequestParam(name = "order", required = false) String sortOrder,
                                  @RequestParam(name = "query", required = false) String query,
                                  Model model) {
        List<Phone> phones = phoneDao.findAll(((pageNumber == null ? 1 : pageNumber) - 1) * PHONES_ON_PAGE, PHONES_ON_PAGE,
                SortField.getValue(sortField.toUpperCase()), SortOrder.getValue(sortOrder.toUpperCase()), query);
        model.addAttribute("phones", phones);
        Long number = phoneDao.numberByQuery(query);
        model.addAttribute("numberOfPhones", number);
        model.addAttribute("numberOfPages", (number + PHONES_ON_PAGE - 1) / PHONES_ON_PAGE);
        return "productList";
    }

   /* @ModelAttribute("cart")
    public Cart cartOnPage() {
        return cartService.getCart();
    }*/
}

