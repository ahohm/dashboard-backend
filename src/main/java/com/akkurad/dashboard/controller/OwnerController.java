package com.akkurad.dashboard.controller;

import com.akkurad.dashboard.dto.OwnerDto;
import com.akkurad.dashboard.model.Owner;
import com.akkurad.dashboard.service.IOwnerService;
import com.akkurad.dashboard.service.RegisterOwnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/owner")
@AllArgsConstructor
@Slf4j
public class OwnerController {

    private IOwnerService iOwnerService;
    private RegisterOwnerService registerOwnerService;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody OwnerDto ownerDto) throws Exception {
        Owner owner = modelMapper.map(ownerDto, Owner.class);
        log.debug(String.valueOf(ownerDto));
        try {
            owner.setPassword(passwordEncoder.encode(owner.getPassword()));
            return new ResponseEntity(iOwnerService.save(owner), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAll(){
        try {
            return ResponseEntity.ok(iOwnerService.findAll());
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(iOwnerService.findById(id));
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value = "byusername", method = RequestMethod.GET)
    public ResponseEntity findByUsername(@PathParam(value = "username") String username){
        try {
            return ResponseEntity.ok(iOwnerService.findByUsername(username));
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id){
        try {
            iOwnerService.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Owner owner){
        try {
            return new ResponseEntity(iOwnerService.update(owner), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
