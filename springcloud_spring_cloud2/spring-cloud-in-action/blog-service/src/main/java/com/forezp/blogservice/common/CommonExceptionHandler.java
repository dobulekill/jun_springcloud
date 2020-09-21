package com.forezp.blogservice.common;

import com.forezp.blogservice.dto.RespDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class CommonExceptionHandler {
    public ResponseEntity<RespDTO> handleException(Exception e){
        RespDTO resp=new RespDTO();
        CommonException taiChiException= (CommonException) e;
        resp.setCode(501);
        resp.setError(taiChiException.getMessage());
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }
}
