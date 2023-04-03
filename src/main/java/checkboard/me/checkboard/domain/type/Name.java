package checkboard.me.checkboard.domain.type;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/*
   @RequiredArgsConstructor
   クラスのprivate finalなフィールドに対してprivate constructorを生成
　　コンストラクタがprivateの場合、外部からインスタンス化(new)されない
    →そのクラスのメソッドしかインスタンス化(new)する方法を知らない

    このような使用方法を含め便利な使い方集を汎用的にパターン化したものをデザインパターンと呼ぶ
*/

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Name {
    private final String value;

//  fromメソッドによってのみ自身をインスタンス化できる
    public static Name from(String name) {
        return new Name(name);
    }

    public boolean equals(String name) {
        return value.equals(name);
    }

    @Override
    public String toString() {
        if(Objects.isNull(this.value)) {
            return "名無しさん";
        }
        return value;
    }
}
