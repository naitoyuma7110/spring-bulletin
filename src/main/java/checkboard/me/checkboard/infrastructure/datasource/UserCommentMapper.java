package checkboard.me.checkboard.infrastructure.datasource;

import checkboard.me.checkboard.application.dto.UserCommentDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
    @Mapper
    JavaメソッドとSQLのマッピングを行う
*/

//　ここではUserCommentをDBに保存するためのSQL(Insert文)をクラスから呼び出せるよう定義する
//  SQLはresourcesディレクトリを参照する

@Mapper
public interface UserCommentMapper {
    @Insert("sql/insertUserComment.sql")
    void insert(@Param("dto") UserCommentDto dto);

    @Insert("sql/test.sql")
    void testInsert();
}
