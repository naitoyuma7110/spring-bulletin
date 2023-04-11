package checkboard.me.checkboard.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/h2-console/**").permitAll()　//      H2が提供する"/h2-console/"から始まる管理画面のエンドポイントに対してはcsrf対策をせず、全てのアクセスを許可する
                .antMatchers("/h2-console/**").hasRole("ADMIN") // h2コンソールへRole:ADMINを持つUserのみアクセス可能
                .antMatchers("/board").hasRole("USER") // "/board"へRole:USERをもつUserのみアクセス可能(BD上、ROLE_USERであるが、内部ロジックが自動で外す)
                .and().formLogin() // ログインについての設定
                .loginPage("/user").permitAll() // "/user"をログインページに設定しアクセスは全て許可
                .defaultSuccessUrl("/board") // "/board"を認証が必要なページに指定し、またログイン成功後の遷移先に設定
                .and().logout() // ログアウトについて
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/user")
                .and().csrf().ignoringAntMatchers("/h2-console/**") // h2コンソールではcsrf設定(formにcsrfトークンをセットし検証する)を解除
                .and().headers().frameOptions().sameOrigin(); // frameOptions().sameOrigin():はsame-originであればiframeを許可している

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

}
