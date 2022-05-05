package com.locationweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationweb.controller.dto.LocationData;
import com.locationweb.entities.Locations;
import com.locationweb.services.LocationService;
import com.locationweb.utility.EmailService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private EmailService emailService;
	
	//handler methods
	
	@RequestMapping("/showLocationPage")
	public String showLocationPage() {
		return "create_location";
	}
	
	
	//@RequestMapping("/saveLocation")
	//public String saveLocationData(Locations location) {
	//	locationService.saveLocation(location);
	//	return"create_location";
	//}
	
	//@RequestMapping("/saveLocation")
	//public String saveLocationData(@RequestParam("id") long id,@RequestParam("name")String name,@RequestParam("codes") String codes,@RequestParam("type") String type)  {
	//	Locations location =new Locations();
	//	location.setId(id);
	//	location.setName(name);
	//	location.setCodes(codes);
	//	location.setType(type);
	//	locationService.saveLocation(location);
	//	return"create_location";
	//}
	
	//dto-data transfer object
	@RequestMapping("/saveLocation")
	public String saveLocationData(@ModelAttribute("loc") Locations location, ModelMap model) {
		locationService.saveLocation(location);
		emailService.sendSimpleMessage("kumarjintu06@gmail.com", "testing", "Welcome message");
		model.addAttribute("msg","location is saved! ");
		return"create_location";
	}
	
//	@RequestMapping("/saveLocation")
//	public String saveLocationData(LocationData loc, ModelMap model) {
//		Locations location =new Locations();
//		location.setId(loc.getId());
//		location.setName(loc.getName());
//		location.setCodes(loc.getCodes());
//		location.setType(loc.getType());
//		 model.addAttribute("msg","location is saved! ");
//		locationService.saveLocation(location);
//		return"create_location";
//	}
	
	@RequestMapping("listall")
	public String listAll(ModelMap model) {
		List<Locations> locations = locationService.getAllLocations();
		model.addAttribute("locations", locations);
		return"search_result";		
	}
	
	@RequestMapping("/delete")
	public String deleteLocation(@RequestParam("id") long id, ModelMap model) {
		locationService.deleteLocationById(id);
		List<Locations> locations = locationService.getAllLocations();
		model.addAttribute("locations", locations);
		return"search_result";				
	}
	
	@RequestMapping("/update")
	public String updateLocation(@RequestParam("id") long id,ModelMap model) {
		Locations location = locationService.getLocationById(id);
		model.addAttribute("location",location);
		return "update_location";
	}
	
	@RequestMapping("/updateData")
	public String updateLocationData(@ModelAttribute("loc") Locations location, ModelMap model) {
		locationService.saveLocation(location);
		model.addAttribute("msg","location is updated! ");
		return"update_location";
	}
	
}
