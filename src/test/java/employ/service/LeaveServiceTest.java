package employ.service;

import employ.entity.Leave;
import employ.repository.LeaveRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LeaveServiceTest {

    @Mock
    private LeaveRepository leaveRepo;

    private LeaveService leaveService;

    @Mock
    private Leave leave;

    @BeforeEach
    void setUp() {
        this.leaveService = new LeaveService(this.leaveRepo);
    }

    @Test
    void addLeave() {
        leaveService.addLeave(leave);
        verify(leaveRepo).save(leave);
    }

    @Test
    void getLeaves() {
        leaveService.getLeaves();
         verify(leaveRepo).findAll();
    }

//    @Test
//    void deleteLeaves(){
//        leaveService.deleteLeaves(leave.getLeaveId());
//        verify(leaveRepo).deleteById(leave.getLeaveId());
//    }
}