package employ.controller;

import employ.entity.Leave;
import employ.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/api/leaves")
    public String addLeave(@RequestBody Leave leave){
        return leaveService.addLeave(leave);
    }

    @GetMapping("/api/leaves")
    public List<Leave> getLeaves(){
        return leaveService.getLeaves();
    }

//    @DeleteMapping("/api/leaves/{id}")
//    public String deleteLeaves(@PathVariable int id){
//        return leaveService.deleteLeaves(id);
//    }

}
