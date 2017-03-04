package com.ivanshyrai.profile;

import com.ivanshyrai.date.USLocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class ProfileController {

    // To make the field th:field in profilePage.html work should include ProfileForm arguments
    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm) {
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            System.out.println("ERROR -- ERROR");

            return "profile/profilePage";
        }
        System.out.println("Profile has been saved - " + profileForm);
        return "redirect:/profile";
    }

    // Returns date format which depends on location to profilePage.html input field "Birth Date"
    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale) {
        return USLocalDateFormatter.getPattern(locale);
    }
}
