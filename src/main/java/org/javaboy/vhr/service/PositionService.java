package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.PositionMapper;
import org.javaboy.vhr.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PositionService
 * @Description: TODO
 * @Author hl
 * @Date 2020/6/2
 * @Version V1.0
 **/
@Service
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPositons() {

        return  positionMapper.getAllPositons();


    }

    public Integer addPosition(Position position) {
        position.setCreateDate(new Date());
        position.setEnabled(true);
      return   positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
         return  positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionsByIds(Integer[] ids) {
       return positionMapper.deletePositionsByIds(ids);
    }
}
