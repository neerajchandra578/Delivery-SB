package com.parcel.delivery.controller;

import com.parcel.delivery.model.DashboardModel;
import com.parcel.delivery.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins={"http://localhost:3000", "http://3.16.158.189:3000"})
@RestController
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/dashview")
    public DashboardModel getDashboardView(){
       return dashboardService.getDashboardView();
    }
}
