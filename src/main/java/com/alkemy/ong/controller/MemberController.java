package com.alkemy.ong.controller;


import com.alkemy.ong.dto.MemberDTO;
import com.alkemy.ong.exception.BadRequestException;

import com.alkemy.ong.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers(){
        List<MemberDTO> result = this.memberService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<MemberDTO> addMember(@Valid @RequestBody MemberDTO memberDto, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
        MemberDTO savedMember = memberService.addMember(memberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@Valid @RequestBody MemberDTO dto,
                                                  @PathVariable Long id,
                                                  BindingResult result){
        if (result.hasErrors()) {throw new BadRequestException(result);}
        return new ResponseEntity<>(memberService.updateById(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable(name = "id") Long id){
        memberService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
