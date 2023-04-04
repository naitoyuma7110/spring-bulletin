package checkboard.me.checkboard.infrastructure.datasource;

import checkboard.me.checkboard.application.dto.UserCommentDto;
import checkboard.me.checkboard.domain.model.UserComment;
import checkboard.me.checkboard.domain.model.UserCommentRepository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
    Datasource
    データ永続化のための実装クラス
    Repositoryインターフェースを継承
    モデルオブジェクトを受け取りDB登録を実行する機能の実装
*/

@RequiredArgsConstructor
@Repository
public class UserCommentDatasource implements UserCommentRepository {
    @Autowired
    private final UserCommentMapper mapper;


    @Override
    public void save(UserComment userComment) {
        mapper.insert(UserCommentDto.from(userComment));
    }

}
