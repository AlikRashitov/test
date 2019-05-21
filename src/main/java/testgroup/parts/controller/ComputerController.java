package testgroup.parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.parts.model.Computer;
import testgroup.parts.service.ComputerService;
import testgroup.parts.service.ComputerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ComputerController {
    private int page;
    private ComputerService computerService;

    @Autowired
    public void setComputerService(ComputerService computerService) {
        this.computerService = computerService;
    }




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allComputers(@RequestParam(defaultValue = "1") int page) {
        this.page=page;
        List<Computer> computers = computerService.allComputers(page);
        int x = computerService.computersCount();
        int partsCount = computerService.partsCount();
        int pagesCount = (partsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("computers");
        modelAndView.addObject("page", page);
        modelAndView.addObject("computersList", computers);
        modelAndView.addObject("partsCount", partsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("x", x);
        return modelAndView;
    }

    @RequestMapping(value = "/true", method = RequestMethod.GET)
    public ModelAndView trueComputers(@RequestParam(defaultValue = "1") int page) {
        this.page=page;
        List<Computer> computers = computerService.trueComputers(page);
        int x = computerService.computersCount();
        int partsCount = computerService.partsCount1();
        int pagesCount = (partsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("computers");
        modelAndView.addObject("page", page);
        modelAndView.addObject("computersList", computers);
        modelAndView.addObject("partsCount", partsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("x", x);
        return modelAndView;
    }



    @RequestMapping(value = "/false", method = RequestMethod.GET)
    public ModelAndView falseComputers(@RequestParam(defaultValue = "1") int page) {
        this.page=page;
        List<Computer> computers = computerService.falseComputers(page);
        int x = computerService.computersCount();
        int partsCount = computerService.partsCount2();
        int pagesCount = (partsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("computers");
        modelAndView.addObject("page", page);
        modelAndView.addObject("computersList", computers);
        modelAndView.addObject("partsCount", partsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("x", x);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id,
                                 @ModelAttribute("message") String message)  {
        Computer computer = computerService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("computer", computer);
        return modelAndView;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView findPage(@ModelAttribute("message") String message, HttpServletRequest request)  {
        String fname= request.getParameter("findname");
        List<Computer> computers = computerService.findComputers(fname);

      //  Computer computer = computerService.getById(1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findPage");
      //  modelAndView.addObject("computer", computer);
        modelAndView.addObject("computersList", computers);
        return modelAndView;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editComputer(@ModelAttribute("computer") Computer computer) {
        ModelAndView modelAndView = new ModelAndView();
        if (computerService.checkName(computer.getName()) || computerService.getById(computer.getId()).getName().equals(computer.getName())) {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("page", page);
            computerService.edit(computer);
        } else {
            modelAndView.addObject("message","part with name \"" + computer.getName() + "\" already exists");
            modelAndView.setViewName("redirect:/edit/" +  + computer.getId());
        }
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(@ModelAttribute("message") String message) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addComputer(@ModelAttribute("computer") Computer computer) {
        ModelAndView modelAndView = new ModelAndView();
        if (computerService.checkName(computer.getName())) {
            modelAndView.setViewName("redirect:/?page=" + this.page);
            modelAndView.addObject("page", page);
            computerService.add(computer);
        } else {
            modelAndView.addObject("message","part with name \"" + computer.getName() + "\" already exists");
            modelAndView.setViewName("redirect:/add");
        }
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteComputer(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
     //   int partsCount = computerService.partsCount();
      //  int page = ((partsCount - 1) % 10 == 0 && partsCount > 10 && this.page == (partsCount + 9)/10) ?
     //           this.page - 1 : this.page;
        modelAndView.setViewName("redirect:/");
     //   modelAndView.addObject("page", page);
        Computer computer = computerService.getById(id);
        computerService.delete(computer);
        return modelAndView;
    }

}
