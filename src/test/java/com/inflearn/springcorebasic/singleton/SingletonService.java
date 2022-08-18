package com.inflearn.springcorebasic.singleton;

public class SingletonService {

    // static영역에 객체 instance를 미리 하나 생성해서 올려둔다.(static에 대해 공부를 해보자!)
    private static final SingletonService instance = new SingletonService();

    // getInstance() 메서드를 통해서만 조회가능하고 이 메서드를 호출하면 항상 같은 인스턴스를 반환.
    public static SingletonService getInstance() {
        return instance;
    }
    
    // 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 외부에서는 new 키워드로 생성하지 못하도록 한다.
    private SingletonService(){
    }
    
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
