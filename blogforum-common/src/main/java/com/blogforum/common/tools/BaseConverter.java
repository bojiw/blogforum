package com.blogforum.common.tools;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;

/**
 * 基础vo po转换类
 * @author wwd
 *
 * @param <PO>
 * @param <VO>
 */
public class BaseConverter<PO, VO> {
    private static final Logger logger = LoggerFactory.getLogger(BaseConverter.class);

    /**
     * 单个对象转换
     */
    public VO convert(PO from, Class<VO> clazz) {
        if (from == null) {
            return null;
        }
        VO to = null;
        try {
            to = clazz.newInstance();
        } catch (Exception e) {
            logger.error("转换类初始化{}对象失败。", clazz, e);
        }
        convert(from, to);
        return to;
    }

    /**
     * 批量对象转换
     */
    public List<VO> convertList(List<PO> fromList, Class<VO> clazz) {
    	if (CollectionUtils.isEmpty(fromList)) {
			return Lists.newArrayList();
		}
        List<VO> toList = Lists.newArrayList();
        for (PO from : fromList) {
            toList.add(convert(from, clazz));
        }
        return toList;
    }

    
    /**
     * 属性拷贝方法，有特殊需求时子类覆写此方法
     */
    protected void convert(PO from, VO to) {
        BeanUtils.copyProperties(from, to);
    }
}
