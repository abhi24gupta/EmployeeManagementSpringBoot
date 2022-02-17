package employ.service;

import employ.entity.Employee;
import employ.entity.Leave;
import employ.exception.ResouceNotFoundException;
import employ.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    @Autowired
    public LeaveRepository leaveRepository;


    public String addLeave(Leave leave) {
        leaveRepository.save(leave);
        return "Leave DATA added to the Database";
    }

    public List<Leave> getLeaves() {
        return leaveRepository.findAll();
    }

    public Leave getLeaveById(int id){
            return leaveRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No leave found to Display. Leave Id : " + id));
    }

    public String deleteLeaves(int id) {
        if(leaveRepository.existsById(id)){
            leaveRepository.deleteById(id);
            return "Leave deleted with id " + id;
        }
        else {
            return "NO leave Data was found with this id";
        }
    }

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public Leave updateLeaves(Leave leave, int id) {
        Leave existingLeave = leaveRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No Such leave present by id "+ id + " Try Again!!"));
        existingLeave.setDate(leave.getDate());
        existingLeave.setReason(leave.getReason());
        existingLeave.setEmployee(leave.getEmployee());
        return leaveRepository.save(existingLeave);
    }
}
