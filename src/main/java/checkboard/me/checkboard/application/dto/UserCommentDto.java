package checkboard.me.checkboard.application.dto;


import checkboard.me.checkboard.domain.model.UserComment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
    DTO：Data Transfer Object
    ドメイン層はシステムの主幹となる機能を担当している重要かつ複雑な部分のため、アプリケーション層やプレゼンテーション層といった
    周辺機能に依存する構造は避けるべき
    DTOはDBなどを使用した永続化処理の際、ドメイン層とアプリケーション層間のデータ型の差を吸収する
*/

//  ここではUserComment型のドメインオブジェクトを直接やり取りせず,DTOに変換している
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentDto {
    private final String name;
    private final String mailAddress;
    private final String comment;

//   getterは@RequiredArgsConstructorにより自動生成
    public static UserCommentDto from(UserComment userComment) {
        return new UserCommentDto(
                userComment.getName().toString(),
                userComment.getMailAddress().toString(),
                userComment.getComment().toString()
        );
    }
}
