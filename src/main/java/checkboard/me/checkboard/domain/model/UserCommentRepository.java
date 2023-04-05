package checkboard.me.checkboard.domain.model;

import checkboard.me.checkboard.domain.type.UserComments;
/*
    Repository：永続化の抽象
    データを永続化させるためにはドメイン層とアプリケーション層でDTOを使用したデータのやり取りを行う
    Repositoryはその際の処理の抽象でありInterfaceとして定義される(永続化処理の抽象)

*/

public interface UserCommentRepository {
//  userComment: domain-modelを受け取り保存処理を実行する
    void save(UserComment userComment);

    void testSave();

    UserComments select();
}
