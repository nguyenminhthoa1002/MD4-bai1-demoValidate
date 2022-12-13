package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Catalog;
import ra.model.service.ICatalogService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("catalogController")
public class CatalogController {
    @Autowired
    public ICatalogService catalogService;

    @GetMapping("getAll")
    public ModelAndView getAllCatalog(Model model){
        ModelAndView mav = new ModelAndView("category");
        List<Catalog> listCatalog = catalogService.getAllCatalog();
        mav.addObject("listCatalog",listCatalog);
        return mav;
    }

    @GetMapping("initCreate")
    public String initCreate(Model model){
        Catalog catNew = new Catalog();
        model.addAttribute("catNew",catNew);
        return "newCatalog";
    }

    @PostMapping("create")
    public String create(@Valid Catalog catNew, BindingResult br){
        if (br.hasErrors()){
            return "newCatalog";
        } else {
            boolean result = catalogService.insertCat(catNew);
            if (result){
                return "redirect:getAll";
            } else {
                return "error";
            }
        }
    }

    @GetMapping("initUpdate")
    public String initUpdate(Model model, int catalogID){
        Catalog catUpdate = (Catalog) catalogService.getById(catalogID);
        model.addAttribute("catUpdate",catUpdate);
        return "updateCatalog";
    }

    @PostMapping("update")
    public String update(Catalog catUpdate){
        boolean result = catalogService.updateCat(catUpdate);
        if (result){
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @GetMapping("delete")
    public String delete(int catalogID){
        boolean result = catalogService.deleteCat(catalogID);
        if (result){
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @GetMapping("search")
    public ModelAndView search(Model model, String searchName){
        ModelAndView mav = new ModelAndView("category");
        List<Catalog> listSearchCatalog = catalogService.listSearchCatalog(searchName);
        model.addAttribute("listCatalog",listSearchCatalog);
        return mav;
    }
}
