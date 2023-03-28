package checkboard.me.checkboard.domain.type;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Comment {
    private final String value;

//  strung -> Comment型へ
    public static Comment from(String comment) {
        return new Comment(comment);
    }

//
    @Override
    public String toString() {
        return value;
    }
}
