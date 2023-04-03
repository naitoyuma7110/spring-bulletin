package checkboard.me.checkboard.application.usecase;

import checkboard.me.checkboard.application.form.CommentForm;
import checkboard.me.checkboard.domain.model.UserComment;
import checkboard.me.checkboard.domain.model.UserCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserCommentUseCase {
    private final UserCommentRepository repository;

 /*
    ユーザの書き込みをDBに反映し、表示するデータをプレゼンテーション層に渡す
    @param commentForm jspとcontroller間のフォーム入力情報
    @return 表示するデータ
 */

    public void write(CommentForm commentForm){
//      フォーム入力情報からモデル作成
        UserComment userComment = UserComment.from(
                commentForm.getName(),
                commentForm.getMailAddress(),
                commentForm.getComment()
        );

        repository.save(userComment);
    }

}
