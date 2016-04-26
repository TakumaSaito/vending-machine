package jp.co.tis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 起動クラス。
 *
 * @author Saito Takuma
 * @since 1.0
 *
 */
@SpringBootApplication
public class App {

    /**
     * 起動のためのmainクラス。
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}