package checkboard.me.checkboard.application.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

//Viewに渡すためのオブジェクトを定義
//@Data:getter,setterの自動作成
@Data
public class CommentForm {
    @Nullable
    @Length(max=20)
    private String name;
    @Nullable
    @Email
    @Length(max=100)
    private String mailAddress;
    @NotNull
    @Length(min=1, max=400)
    private String comment;
}
