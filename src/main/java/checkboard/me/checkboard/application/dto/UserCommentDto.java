package checkboard.me.checkboard.application.dto;


import checkboard.me.checkboard.domain.model.UserComment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
    DTO：Data Tranfer Object
    ドメイン層はシステムの主幹となる機能を担当している重要かつ複雑な部分のため、アプリケーション層やプレゼンテーション層といった
    周辺機能に依存する(意識する)構造は避けるべき
    DTOはDBなどを使用した永続化処理の際、ドメイン層からアプリケーション層にデータを引き渡すために使用される
*/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentDto {
    private final String name;
    private final String mailAddress;
    private final String comment;

    public static UserCommentDto from(UserComment userComment) {
        return new UserCommentDto(
                userComment.getName().toString(),
                userComment.getMailAddress().toString(),
                userComment.getComment().toString()
        );
    }
}
