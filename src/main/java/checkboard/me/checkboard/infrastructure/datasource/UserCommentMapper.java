package checkboard.me.checkboard.infrastructure.datasource;

import checkboard.me.checkboard.application.dto.UserCommentDto;
import checkboard.me.checkboard.application.dto.UserCommentReadDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
    @Mapper
    JavaメソッドとSQLのマッピングを行う
    javaオブジェクトとSQLとの間でデータの自動変換
*/

//　ここではUserCommentをDBに保存するためのSQL(Insert文)をクラスから呼び出せるよう定義する
//  SQLはresourcesディレクトリを参照する

@Mapper
public interface UserCommentMapper {
    @Insert("sql/insertUserComment.sql")
    void insert(@Param("dto") UserCommentDto dto);

    @Insert("sql/test.sql")
    void testInsert();

//  sqlで取得するデータが複数の場合List型で取得
    @Select("sql/selectUserComment.sql")
    List<UserCommentReadDto> select();
}
