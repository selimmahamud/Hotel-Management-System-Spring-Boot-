package org.idb.Tourism.controller;

import org.idb.Tourism.entity.Roomtype;
import org.idb.Tourism.service.RoomtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomtypeController {

    @Autowired
    RoomtypeService roomtypeService;

    @RequestMapping("/roomtype_form")
    public  String roomtypeForm(Model m){
        m.addAttribute("roomtype", new Roomtype());
        m.addAttribute("allrtype", roomtypeService.getAllRoomtype());

        return "roomtype-form";
    }

    @RequestMapping("/all_roomtype_list")
    public  String roomtypeList(Model m){
        m.addAttribute("allrtype", roomtypeService.getAllRoomtype());
        m.addAttribute("roomtype", new Roomtype());
        return "roomtypelist";
    }
    @RequestMapping ("/save_roomtype")
    public  String roomtypeAdd(@ModelAttribute("roomtype") Roomtype rt, Model m){
        roomtypeService.saveRoomtype(rt);

        return "redirect:/roomtype_form";
    }

    @RequestMapping("/delete_roomtype/{rtid}")
    public  String deleteroomtype(@PathVariable("rtid") Integer rtid){
        roomtypeService.deleteRoomtype(rtid);
        return "redirect:/all_roomtype_list";
    }

    @RequestMapping("/edit_roomtype/{rtid}")
    public String updateRoomtype(@PathVariable("rtid") Integer rtid, Model m){
        Roomtype rt = roomtypeService.findByIdRoomType(rtid);
        m.addAttribute("roomtype", rt);
        return "roomtype-form";
    }

}
