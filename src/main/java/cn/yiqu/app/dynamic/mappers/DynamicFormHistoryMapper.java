package cn.yiqu.app.dynamic.mappers;

import cn.ifloat.brick.sprofile.mybatis.common.BasicMapper;
import cn.yiqu.app.dynamic.domain.DynamicFormHistory;
import cn.yiqu.app.dynamic.domain.vo.DynamicFormHistoryVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DynamicFormHistoryMapper extends BasicMapper<DynamicFormHistory> {

    String SQL = "<script>SELECT ID,CODE,DATA,STATUS,FORM_TYPE,VERSION_ID,JOB_ID,ORG_ID,CREATE_TIME,CREATE_BY,UPDATE_TIME,UPDATE_BY FROM DYNAMIC_FORM_HISTORY ${ew.customSqlSegment}</script>";

    @Select(value = SQL)
    List<DynamicFormHistoryVo> listVo(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select(value = SQL)
    IPage<DynamicFormHistoryVo> pagerVo(IPage page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
