package com.example.tiary.admin.service;

import com.example.tiary.admin.constant.WriterStatus;
import com.example.tiary.admin.entity.WriteApproval;
import com.example.tiary.admin.repository.ApprovalRepository;
import com.example.tiary.myPage.dto.response.ResponseUsersDto;
import com.example.tiary.users.constant.UserStatus;
import com.example.tiary.users.dto.UserDto;
import com.example.tiary.users.entity.Users;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

	// 작가 신청
    private final ApprovalRepository approvalRepository;

    public AdminService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    //작가 신청 버튼 누를 때
    @Transactional
    public WriteApproval addApproval(UserDto userDto){
        WriteApproval writeApproval = new WriteApproval(userDto.getUsers().getId(), WriterStatus.Approving,userDto.getUsers().getNickname(),userDto.getUsers().getEmail(),userDto.getUsers().getUserPicture(),userDto.getUsers().getUserStatus());
        WriteApproval writeApprovalResult = approvalRepository.save(writeApproval);
        return writeApprovalResult;
    }
    //작가 관리 페이지 들어갈때
    @Transactional
    public List<WriteApproval> listApproval(){
        List<WriteApproval> writeApprovalList = approvalRepository.findAll();
        return writeApprovalList;
    }
    //작가 수락할 때
    @Transactional
    public WriteApproval accept(Long userId){
        WriteApproval writeApproval = approvalRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("회원이 존재하지 않습니다."));
        writeApproval.updateStatus(WriterStatus.Accepted);
        return approvalRepository.save(writeApproval);
    }
    //작가 거절할 때
    @Transactional
    public WriteApproval reject(Long userId){
        WriteApproval writeApproval = approvalRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("회원이 존재하지 않습니다."));
        writeApproval.updateStatus(WriterStatus.Rejected);
        return approvalRepository.save(writeApproval);
    }
    // 공지사항
}
