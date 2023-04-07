package checkboard.me.checkboard.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
    DIコンテナの基本的な機能の検証
    DIコンテナがコンポーネントに対し外部から依存性を注入することで、コンポーネント間の結合を疎にする
    また各コンポーネントの依存関係を一元管理できるためコンポーネント単位ごとにモックなどに置き換えテストが可能
    @Beanはデフォルトでシングルトンとしてインスタンスを登録する
*/

@Configuration
public class CreateBean {

//  @Beanが付与されたメソッドでCountインスタンスをreturnする事でDI登録される
    @Bean
    public Count count(){
        return new Count();
    }


}
