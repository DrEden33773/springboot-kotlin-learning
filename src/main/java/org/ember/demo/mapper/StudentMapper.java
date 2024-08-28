package org.ember.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mybatisflex.core.BaseMapper;
import org.ember.demo.entity.Student;

/**
 *  映射层。
 *
 * @author Eden
 * @since 2024-08-28
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
