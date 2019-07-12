package badminton.skb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import badminton.skb.beans.Skb;
import badminton.skb.dao.SkbDao;

@Controller
public class SkbController {
	@Autowired
	SkbDao dao;

	/* Public entrance */
	@RequestMapping("/badminton/skb/entrance")
	public String skbPublic(Model m) {
		List<Skb> list = dao.getSkbSchedule();
		m.addAttribute("list", list);
		return "skbPublicPage";
	}

	/* Admin View*/
	@RequestMapping("/badminton/skb/admin")
	public String skbAdmin(Model m) {
		List<Skb> list = dao.getSkbSchedule();
		m.addAttribute("list", list);
		return "skbAdminPage";
	}
	
	/* edit  */
	@RequestMapping(value = "/badminton/skb/admin/editskb/{id}")
	public String edit(@PathVariable int id, Model m) {
		Skb skb = dao.getSkbById(id);
		m.addAttribute("command", skb);
		return "skbeditform";
	}
	
	/* create */
	@RequestMapping(value = "/badminton/skb/admin/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("skb") Skb skb) {
		dao.save(skb);
		return "redirect:/badminton/skb/admin";
	}
	
	/* add */
	@RequestMapping("/badminton/skb/admin/skbform")
	public String showform(Model m) {
		m.addAttribute("command", new Skb());
		return "skbform";
	}

	/* update */
	@RequestMapping(value = "/badminton/skb/admin/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("skb") Skb skb) {
		dao.update(skb);
		return "redirect:/badminton/skb/admin";
	}

	/* delete */
	@RequestMapping(value = "/badminton/skb/admin/deleteskb/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/badminton/skb/admin";
	}
}