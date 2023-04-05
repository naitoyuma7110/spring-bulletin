package checkboard.me.checkboard.infrastructure.datasource;

import checkboard.me.checkboard.application.dto.UserCommentDto;
import checkboard.me.checkboard.application.dto.UserCommentReadDto;
import checkboard.me.checkboard.domain.model.UserComment;
import checkboard.me.checkboard.domain.model.UserCommentRepository;

import checkboard.me.checkboard.domain.type.UserComments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/*
    Datasource
    データ永続化のための実装クラス
    Repositoryインターフェースを継承
    モデルオブジェクトを受け取りDB登録を実行する機能の実装
*/

@RequiredArgsConstructor
@Repository
public class UserCommentDatasource implements UserCommentRepository {
    private final UserCommentMapper mapper;

    @Override
    public void save(UserComment userComment) {
        mapper.insert(UserCommentDto.from(userComment));
    }

    @Override
    public  void testSave(){
        mapper.testInsert();
    }

    @Override
    public UserComments select(){
        List<UserCommentReadDto> dtos = mapper.select();

        /*
            Stream APIにおけるラムダ式の利用
            Javaにおけるラムダ式はあくまでも、クラスの宣言とインスタンスの作成を同時に行うための新たな表記法
        */

//      UserCommentReadDtoのリストを、UserComments.UserCommentクラスのリストに変換
        return UserComments.from(
            dtos.stream().map(dto -> UserComments.UserComment.from(
                dto.getId(),
                dto.getName(),
                dto.getMailAddress(),
                dto.getComment(),
                dto.getCreatedAt()
            )).collect(Collectors.toList())
        );
    }
}
