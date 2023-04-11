package checkboard.me.checkboard.infrastructure.datasource.condig;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

/*
    Spring-SeculityによるJDBC認証の設定
    JDBCはJavaからRDBへの接続インターフェースで、認証情報をDB上に保存し検証するための設定をここで行う
    各機能を提供するコンポーネントをDIコンテナへ登録する
*/

@Configuration
@RequiredArgsConstructor
public class DatabaseConfig {
    private final DataSource dataSource;


//  DIコンテナへの登録UserDetailsManagerとして、インスタンス化したJdbcUserDetailsManagerを定義
    @Bean
    public UserDetailsManager userDetailsManager() {
        return new JdbcUserDetailsManager(dataSource);
    }

/*
    ハッシュ化アルゴリズム：デフォルトでbcryptを使用
    PasswordEncoderによりDB上にハッシュ化されたパスワードが保存される

    - 暗号化とハッシュ化の違いに注意
 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
