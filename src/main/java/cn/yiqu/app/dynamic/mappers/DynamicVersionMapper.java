package cn.yiqu.app.dynamic.mappers;

import cn.ifloat.brick.sprofile.mybatis.common.BasicMapper;
import cn.yiqu.app.dynamic.domain.DynamicVersion;
import cn.yiqu.app.dynamic.domain.vo.DynamicVersionVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DynamicVersionMapper extends BasicMapper<DynamicVersion> {

    String SQL = "<script>SELECT ID,VERSION_NUMBER,VERSION_NAME,JOB_ID,ORG_ID,CREATE_TIME,CREATE_BY,UPDATE_TIME,UPDATE_BY FROM DYNAMIC_VERSION ${ew.customSqlSegment}</script>";

    @Select(value = SQL)
    List<DynamicVersionVo> listVo(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select(value = SQL)
    IPage<DynamicVersionVo> pagerVo(IPage page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
