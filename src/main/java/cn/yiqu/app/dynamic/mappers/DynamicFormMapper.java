package cn.yiqu.app.dynamic.mappers;

import cn.ifloat.brick.sprofile.mybatis.common.BasicMapper;
import cn.yiqu.app.dynamic.domain.DynamicForm;
import cn.yiqu.app.dynamic.domain.vo.DynamicFormVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DynamicFormMapper extends BasicMapper<DynamicForm> {

    String SQL = "<script>SELECT ID,CODE,NAME,FORM_KEY,DATA,STATUS,FORM_TYPE,VERSION_ID,JOB_ID,ORG_ID,CREATE_TIME,CREATE_BY,UPDATE_TIME,UPDATE_BY FROM DYNAMIC_FORM ${ew.customSqlSegment}</script>";

    @Select(value = SQL)
    List<DynamicFormVo> listVo(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select(value = SQL)
    IPage<DynamicFormVo> pagerVo(IPage page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
