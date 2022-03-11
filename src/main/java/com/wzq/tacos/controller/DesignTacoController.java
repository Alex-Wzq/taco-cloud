package com.wzq.tacos.controller;

import com.wzq.tacos.model.Ingredient;
import com.wzq.tacos.model.Ingredient.Type;
import com.wzq.tacos.model.Order;
import com.wzq.tacos.model.Taco;
import com.wzq.tacos.repository.IngredientRepository;
import com.wzq.tacos.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 第一个是 @Slf4j，它是 Lombok 提供的注释，在运行时将自动生成类中的 SLF4J（Java 的简单日志门面，https://www.slf4j.org/）记录器。
// 这个适当的注释具有与显式地在类中添加以下行相同的效果
// private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order") // @SessionAttributes 注解指定了任何模型对象，比如应该保存在会话中的 order 属性，并且可以跨多个请求使用。 (放到session，多个请求之间共用数据)
public class DesignTacoController {

    @Autowired
    private IngredientRepository ingredientRepo;

    @Autowired
    private TacoRepository designRepo;

    // @ModelAttribute 注解确保在模型中能够创建 Order 对象
    // 返回值对象会被默认放到隐含的Model中，在Model中的key为返回值首字母小写，value为返回的值。
    @ModelAttribute(name = "order")
    
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());
        return "design";
    }

    // provided by 'aexiaosong'
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        Taco saved = designRepo.save(design);
        order.addDesign(saved);

        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

}
