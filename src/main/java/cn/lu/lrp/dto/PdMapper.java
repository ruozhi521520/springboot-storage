package cn.lu.lrp.dto;

import cn.lu.lrp.entity.Pd;
import cn.lu.lrp.entity.PdLine;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PdMapper {


    Page<Pd> selectList(Pd param);

    List<Pd> selectPd(Pd param);

    int save(Pd param);

    Page<PdLine> selectLineList(int id);

    int saveLine(Pd param);


}
