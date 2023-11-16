package com.dmadev.springJPAHiber.controllers;
import com.dmadev.springJPAHiber.models.Car;
import com.dmadev.springJPAHiber.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("car",carService.findAll());
        return "car/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        model.addAttribute("car",carService.findOne(id));
        return "car/show";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") Car car){
        return "car/new";
    }

    @GetMapping("/new")
    public String create(@ModelAttribute("car") @Valid Car car,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "car/new";
        }
        carService.save(car);
        return "car/new";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
            model.addAttribute("car",carService.findOne(id));
            return "car/edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult,@PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "car/edit";
        }
        carService.update(id,car);
        return "redirect:/car";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        carService.delete(id);
        return "redirect:/car";
    }
}
