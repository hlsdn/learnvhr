package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.Position;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PositionController
 * @Description: TODO
 * @Author hl
 * @Date 2020/6/2
 * @Version V1.0
 **/
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions(){
        return  positionService.getAllPositons();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if(positionService.addPosition(position)==1){
            return RespBean.ok("插入成功");
        }
        return  RespBean.error("插入失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
          if(positionService.updatePosition(position)==1){
              return  RespBean.ok("更新成功");
          }
          return  RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public  RespBean deletePosition(@PathVariable Integer id ){

        if(positionService.deletePosition(id)==1){
            return  RespBean.ok("删除成功");

        }
        return  RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deletePositionsByIds(Integer[] ids){
      if(positionService.deletePositionsByIds(ids)==ids.length){
          return  RespBean.ok("删除成功");
      }
      return  RespBean.error("删除失败");

    }


}
