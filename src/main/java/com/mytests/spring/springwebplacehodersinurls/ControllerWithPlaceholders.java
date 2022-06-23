package com.mytests.spring.springwebplacehodersinurls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pp_test")
public class ControllerWithPlaceholders {
    @GetMapping("/ppm0/buzz")
    public String ppm0() {
        return "ppm0";
    }

    @GetMapping("/ppm1/${foo-prop1}")
    public String ppm1() {
        return "ppm1";
    }
    @GetMapping("/ppm1/foo")
    public String ppm1_1() {
        return "ppm1_foo";
    }
    @GetMapping("/ppm1/bar")
    public String ppm1_2() {
        return "ppm1_bar";
    }
    @GetMapping("/ppm2/${foo-prop1}/{pv1}")
    public String ppm2(@PathVariable("pv1") String pv1) {
        return "ppm2";
    }
    @GetMapping("/ppm3/${foo-prop1}/${foo-prop2}")
    public String ppm3() {
        return "ppm3";
    }
}
