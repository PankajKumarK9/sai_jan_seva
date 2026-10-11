package org.saijankalyan.web;

import java.time.Year;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebsiteController {
    private static final List<Course> COURSES = List.of(
        new Course("IT-ITeS Hardware & Networking Technician", "PMKVY | NSQF Level 4", "3 Months", "Free (PMKVY)",
            "Computer hardware assembly, repair, networking setup, OS installation, troubleshooting and IT support."),
        new Course("Data Entry Operator", "PMKVY | IT-ITeS Sector", "2 Months", "Free (PMKVY)",
            "Fast and accurate data entry, MS Word, Excel, typing speed, spreadsheet work and office operations."),
        new Course("Domestic Data Entry Operator", "PMKVY Certified", "1 Month", "Free (PMKVY)",
            "Hindi and English typing, data formatting, verification and domestic BPO work process training."),
        new Course("CRM Domestic Voice", "PMKVY | Customer Service", "2 Months", "Free (PMKVY)",
            "Customer communication, call handling, CRM basics and complaint resolution for BPO jobs."),
        new Course("IT Support Technician", "PMKVY | NSQF Level 3", "3 Months", "Free (PMKVY)",
            "Windows setup, hardware troubleshooting, printer/scanner maintenance and basic network configuration."),
        new Course("Cyber Security Awareness", "PMKVY | Digital Safety", "1 Month", "Free (PMKVY)",
            "Internet safety, password management, phishing awareness and safe digital payment practices.")
    );

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("year", Year.now().getValue());
        model.addAttribute("courses", COURSES);
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("page", "home");
        model.addAttribute("title", "Sai Jan Kalyan Seva Sansthan - PMKVY Computer Skill Training");
        return "index";
    }

    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("page", "courses");
        model.addAttribute("title", "Computer Courses - Sai Jan Kalyan Seva Sansthan");
        return "courses";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("page", "about");
        model.addAttribute("title", "About Us - Sai Jan Kalyan Seva Sansthan");
        return "about";
    }

    @GetMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("page", "gallery");
        model.addAttribute("title", "Gallery - Sai Jan Kalyan Seva Sansthan");
        return "gallery";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("page", "contact");
        model.addAttribute("title", "Contact Us - Sai Jan Kalyan Seva Sansthan");
        if (!model.containsAttribute("inquiry")) {
            model.addAttribute("inquiry", new Inquiry());
        }
        return "contact";
    }

    @PostMapping("/contact")
    public String submitInquiry(@Valid @ModelAttribute Inquiry inquiry,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("page", "contact");
            model.addAttribute("title", "Contact Us - Sai Jan Kalyan Seva Sansthan");
            return "contact";
        }
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/contact";
    }

    public record Course(String title, String subtitle, String duration, String fee, String description) {
    }

    public static class Inquiry {
        @NotBlank
        private String name;

        @NotBlank
        private String phone;

        @Email
        private String email;

        @NotBlank
        private String course;

        private String message;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
