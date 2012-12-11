package org.wmichina.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import org.wmichina.crm.entity.BizCourse;
import org.wmichina.crm.entity.example.BizCourseExample;
import org.wmichina.crm.provider.BizCourseSqlProvider;

@Repository(value="bizCourseMapper")
public interface BizCourseMapper {
    @SelectProvider(type=BizCourseSqlProvider.class, method="countByExample")
    int countByExample(BizCourseExample example);

    @DeleteProvider(type=BizCourseSqlProvider.class, method="deleteByExample")
    int deleteByExample(BizCourseExample example);

    @Delete({
        "delete from biz_course",
        "where course_id = #{courseId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer courseId);

    @Insert({
        "insert into biz_course (course_id, course_code, ",
        "course_name, course_category, ",
        "course_class, course_type, ",
        "learning_mode, learning_time, ",
        "learning_hours, learning_term, ",
        "learning_city, course_price, ",
        "discount_1, discount_reason_1, ",
        "discount_2, discount_reason_2, ",
        "discount_3, discount_reason_3, ",
        "discount_4, discount_reason_4, ",
        "discount_5, discount_reason_5, ",
        "is_valid, is_onsale, on_date, ",
        "off_date, remark, create_date, ",
        "create_user, update_date, ",
        "update_user, description)",
        "values (#{courseId,jdbcType=INTEGER}, #{courseCode,jdbcType=VARCHAR}, ",
        "#{courseName,jdbcType=VARCHAR}, #{courseCategory,jdbcType=VARCHAR}, ",
        "#{courseClass,jdbcType=VARCHAR}, #{courseType,jdbcType=VARCHAR}, ",
        "#{learningMode,jdbcType=VARCHAR}, #{learningTime,jdbcType=VARCHAR}, ",
        "#{learningHours,jdbcType=INTEGER}, #{learningTerm,jdbcType=VARCHAR}, ",
        "#{learningCity,jdbcType=VARCHAR}, #{coursePrice,jdbcType=DOUBLE}, ",
        "#{discount1,jdbcType=DOUBLE}, #{discountReason1,jdbcType=VARCHAR}, ",
        "#{discount2,jdbcType=DOUBLE}, #{discountReason2,jdbcType=VARCHAR}, ",
        "#{discount3,jdbcType=DOUBLE}, #{discountReason3,jdbcType=VARCHAR}, ",
        "#{discount4,jdbcType=DOUBLE}, #{discountReason4,jdbcType=VARCHAR}, ",
        "#{discount5,jdbcType=DOUBLE}, #{discountReason5,jdbcType=VARCHAR}, ",
        "#{isValid,jdbcType=BIT}, #{isOnsale,jdbcType=BIT}, #{onDate,jdbcType=DATE}, ",
        "#{offDate,jdbcType=DATE}, #{remark,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{description,jdbcType=LONGVARBINARY})"
    })
    @Options(useGeneratedKeys=true,keyProperty="courseId")
    int insert(BizCourse record);

    @InsertProvider(type=BizCourseSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="courseId")
    int insertSelective(BizCourse record);

    @SelectProvider(type=BizCourseSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_code", property="courseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_category", property="courseCategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_class", property="courseClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_type", property="courseType", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_mode", property="learningMode", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_time", property="learningTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_hours", property="learningHours", jdbcType=JdbcType.INTEGER),
        @Result(column="learning_term", property="learningTerm", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_city", property="learningCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_price", property="coursePrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_1", property="discount1", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_1", property="discountReason1", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_2", property="discount2", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_2", property="discountReason2", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_3", property="discount3", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_3", property="discountReason3", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_4", property="discount4", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_4", property="discountReason4", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_5", property="discount5", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_5", property="discountReason5", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="is_onsale", property="isOnsale", jdbcType=JdbcType.BIT),
        @Result(column="on_date", property="onDate", jdbcType=JdbcType.DATE),
        @Result(column="off_date", property="offDate", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<BizCourse> selectByExampleWithBLOBs(BizCourseExample example);

    @SelectProvider(type=BizCourseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_code", property="courseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_category", property="courseCategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_class", property="courseClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_type", property="courseType", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_mode", property="learningMode", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_time", property="learningTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_hours", property="learningHours", jdbcType=JdbcType.INTEGER),
        @Result(column="learning_term", property="learningTerm", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_city", property="learningCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_price", property="coursePrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_1", property="discount1", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_1", property="discountReason1", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_2", property="discount2", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_2", property="discountReason2", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_3", property="discount3", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_3", property="discountReason3", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_4", property="discount4", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_4", property="discountReason4", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_5", property="discount5", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_5", property="discountReason5", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="is_onsale", property="isOnsale", jdbcType=JdbcType.BIT),
        @Result(column="on_date", property="onDate", jdbcType=JdbcType.DATE),
        @Result(column="off_date", property="offDate", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<BizCourse> selectByExample(BizCourseExample example);

    @Select({
        "select",
        "course_id, course_code, course_name, course_category, course_class, course_type, ",
        "learning_mode, learning_time, learning_hours, learning_term, learning_city, ",
        "course_price, discount_1, discount_reason_1, discount_2, discount_reason_2, ",
        "discount_3, discount_reason_3, discount_4, discount_reason_4, discount_5, discount_reason_5, ",
        "is_valid, is_onsale, on_date, off_date, remark, create_date, create_user, update_date, ",
        "update_user, description",
        "from biz_course",
        "where course_id = #{courseId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_code", property="courseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_category", property="courseCategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_class", property="courseClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_type", property="courseType", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_mode", property="learningMode", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_time", property="learningTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_hours", property="learningHours", jdbcType=JdbcType.INTEGER),
        @Result(column="learning_term", property="learningTerm", jdbcType=JdbcType.VARCHAR),
        @Result(column="learning_city", property="learningCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_price", property="coursePrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_1", property="discount1", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_1", property="discountReason1", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_2", property="discount2", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_2", property="discountReason2", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_3", property="discount3", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_3", property="discountReason3", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_4", property="discount4", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_4", property="discountReason4", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_5", property="discount5", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_5", property="discountReason5", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="is_onsale", property="isOnsale", jdbcType=JdbcType.BIT),
        @Result(column="on_date", property="onDate", jdbcType=JdbcType.DATE),
        @Result(column="off_date", property="offDate", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARBINARY)
    })
    BizCourse selectByPrimaryKey(Integer courseId);

    @UpdateProvider(type=BizCourseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BizCourse record, @Param("example") BizCourseExample example);

    @UpdateProvider(type=BizCourseSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") BizCourse record, @Param("example") BizCourseExample example);

    @UpdateProvider(type=BizCourseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BizCourse record, @Param("example") BizCourseExample example);

    @UpdateProvider(type=BizCourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BizCourse record);

    @Update({
        "update biz_course",
        "set course_code = #{courseCode,jdbcType=VARCHAR},",
          "course_name = #{courseName,jdbcType=VARCHAR},",
          "course_category = #{courseCategory,jdbcType=VARCHAR},",
          "course_class = #{courseClass,jdbcType=VARCHAR},",
          "course_type = #{courseType,jdbcType=VARCHAR},",
          "learning_mode = #{learningMode,jdbcType=VARCHAR},",
          "learning_time = #{learningTime,jdbcType=VARCHAR},",
          "learning_hours = #{learningHours,jdbcType=INTEGER},",
          "learning_term = #{learningTerm,jdbcType=VARCHAR},",
          "learning_city = #{learningCity,jdbcType=VARCHAR},",
          "course_price = #{coursePrice,jdbcType=DOUBLE},",
          "discount_1 = #{discount1,jdbcType=DOUBLE},",
          "discount_reason_1 = #{discountReason1,jdbcType=VARCHAR},",
          "discount_2 = #{discount2,jdbcType=DOUBLE},",
          "discount_reason_2 = #{discountReason2,jdbcType=VARCHAR},",
          "discount_3 = #{discount3,jdbcType=DOUBLE},",
          "discount_reason_3 = #{discountReason3,jdbcType=VARCHAR},",
          "discount_4 = #{discount4,jdbcType=DOUBLE},",
          "discount_reason_4 = #{discountReason4,jdbcType=VARCHAR},",
          "discount_5 = #{discount5,jdbcType=DOUBLE},",
          "discount_reason_5 = #{discountReason5,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "is_onsale = #{isOnsale,jdbcType=BIT},",
          "on_date = #{onDate,jdbcType=DATE},",
          "off_date = #{offDate,jdbcType=DATE},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARBINARY}",
        "where course_id = #{courseId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(BizCourse record);

    @Update({
        "update biz_course",
        "set course_code = #{courseCode,jdbcType=VARCHAR},",
          "course_name = #{courseName,jdbcType=VARCHAR},",
          "course_category = #{courseCategory,jdbcType=VARCHAR},",
          "course_class = #{courseClass,jdbcType=VARCHAR},",
          "course_type = #{courseType,jdbcType=VARCHAR},",
          "learning_mode = #{learningMode,jdbcType=VARCHAR},",
          "learning_time = #{learningTime,jdbcType=VARCHAR},",
          "learning_hours = #{learningHours,jdbcType=INTEGER},",
          "learning_term = #{learningTerm,jdbcType=VARCHAR},",
          "learning_city = #{learningCity,jdbcType=VARCHAR},",
          "course_price = #{coursePrice,jdbcType=DOUBLE},",
          "discount_1 = #{discount1,jdbcType=DOUBLE},",
          "discount_reason_1 = #{discountReason1,jdbcType=VARCHAR},",
          "discount_2 = #{discount2,jdbcType=DOUBLE},",
          "discount_reason_2 = #{discountReason2,jdbcType=VARCHAR},",
          "discount_3 = #{discount3,jdbcType=DOUBLE},",
          "discount_reason_3 = #{discountReason3,jdbcType=VARCHAR},",
          "discount_4 = #{discount4,jdbcType=DOUBLE},",
          "discount_reason_4 = #{discountReason4,jdbcType=VARCHAR},",
          "discount_5 = #{discount5,jdbcType=DOUBLE},",
          "discount_reason_5 = #{discountReason5,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "is_onsale = #{isOnsale,jdbcType=BIT},",
          "on_date = #{onDate,jdbcType=DATE},",
          "off_date = #{offDate,jdbcType=DATE},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where course_id = #{courseId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BizCourse record);
}