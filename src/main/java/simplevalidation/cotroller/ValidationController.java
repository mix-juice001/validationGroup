package simplevalidation.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import simplevalidation.bean.Person;
import simplevalidation.bean.Sex;
import simplevalidation.bean.SexType;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ValidationController {

    @ModelAttribute("radioEnum")
    public SexType[] sexTypeList() {
        return SexType.values();
    }

    @RequestMapping("/sample")
    public String validateGroup(@Validated Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "simpleValidation";
        }
        return "result";
    }

    @RequestMapping(value = "/sample", params = "sex=MALE")
    public String validateGroupMale(@Validated({Person.GroupMale.class}) Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "simpleValidation";
        }
        return "result";
    }
    @RequestMapping("/")
    public String welcome(@ModelAttribute Person person) {
        return "simpleValidation";
    }
}
