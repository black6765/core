package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        // private 생성자. 외부에서 new 키워드를 통한 객체 생성을 막음(컴파일 오류)
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
