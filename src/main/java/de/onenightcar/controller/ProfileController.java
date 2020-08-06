package de.onenightcar.controller;

import de.onenightcar.repositories.personRepository.CustomerRepository;
import de.onenightcar.repositories.personRepository.EmployeeRepository;
import de.onenightcar.repositories.personRepository.PaymentMethodRepository;
import de.onenightcar.repositories.personRepository.PersonAddressRepository;
import de.onenightcar.repositories.rentalRepository.ElectricRentalRepository;
import de.onenightcar.repositories.rentalRepository.FuelRentalRepository;
import de.onenightcar.util.CookieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;


@Controller
@RequestMapping(path = "/person")
public class ProfileController {
    @Autowired      // This means to get the bean called paymentMethodRepository
    // Which is auto-generated by Spring, we will use it to handle the data

    private final PaymentMethodRepository paymentMethodRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final PersonAddressRepository personAddressRepository;
    private final FuelRentalRepository fuelRentalRepository;
    private final ElectricRentalRepository electricRentalRepository;



    public ProfileController(PaymentMethodRepository paymentMethodRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository, PersonAddressRepository personAddressRepository, FuelRentalRepository fuelRentalRepository, ElectricRentalRepository electricRentalRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.personAddressRepository = personAddressRepository;
        this.fuelRentalRepository = fuelRentalRepository;
        this.electricRentalRepository = electricRentalRepository;
    }

//    @RequestMapping(path = "/profile/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public String getCustomerWithID(Model model, @PathVariable("id") Long id) {
//
//        model.addAttribute("customer", customerRepository.getById(id));
//        model.addAttribute("fuelRentals", fuelRentalRepository.getAllByCustomer(customerRepository.getById(id)));
//        model.addAttribute("electricRentals", electricRentalRepository.getAllByCustomer(customerRepository.getById(id)));
//
//        return "person/profile";
//
//
//    }

//    @RequestMapping(path = "/profile/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public String getProfileWithID(org.springframework.ui.Model model, @PathVariable("id") Long id) {
//
//        model.addAttribute("customer", customerRepository.getById(id));
//        model.addAttribute("fuelRentals", fuelRentalRepository.getAllByCustomer(customerRepository.getById(id)));
//        model.addAttribute("electricRentals", electricRentalRepository.getAllByCustomer(customerRepository.getById(id)));
//
//        return "person/profile";
//    }

//@RequestMapping(path = "/profile", method = RequestMethod.GET)
//@ResponseStatus(HttpStatus.OK)
//public String getPaymentMethods(Model model) {
//
//    model.addAttribute("paymentMethods", paymentMethodRepository.findAll());
//
//    return "person/profile";
//}

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getProfile(HttpServletRequest request, Model model) {

//        model.addAttribute("customer", customerRepository.getById(id));
//        model.addAttribute("fuelRentals", fuelRentalRepository.getAllByCustomer(customerRepository.getById(id)));
//        model.addAttribute("electricRentals", electricRentalRepository.getAllByCustomer(customerRepository.getById(id)));

        //////Create the Model and View and add the view//////
        ModelAndView mav = new ModelAndView("/person/profile");

        Cookie[] cookies = request.getCookies();

//        //Get all different cities from the Database
//        List<String> parkingAreaCities = parkingAreaAddressRepository.getDistinctCity();

        //Retrieve the correct user from the logged in user
        Long customerId = CookieHelper.getUserCookieId(cookies, "userId");
        mav.addObject("customer", customerRepository.getById(customerId));



        if(!CookieHelper.proveCookieExistence(cookies, "userId")) {
            mav.setViewName("index");
            mav.addObject("error", true);
            mav.addObject("errorText", "You should be Logged in to do that!");
            mav.addObject("loggedIn", false);
        }

        else
        {
            //Add the needed object for the rendering of the view
            //The object that should be populated in the form of the view
            mav.addObject("fuelRental", fuelRentalRepository.getAllByCustomer(customerRepository.getById(customerId)));
            mav.addObject("electricRentalA" ,electricRentalRepository.getAllByCustomer(customerRepository.getById(customerId)));
            mav.addObject("customers", customerRepository.getById(customerId));
            mav.addObject("currentDate", LocalDate.now());
            mav.addObject("loggedIn", true);
        }

        return mav;
    }

}
