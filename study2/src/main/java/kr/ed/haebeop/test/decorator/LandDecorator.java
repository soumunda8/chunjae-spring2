package kr.ed.haebeop.test.decorator;

public class LandDecorator extends DisplayDecorator {
    
    // 기준 표시 클래스 설정
    public LandDecorator(Display decoratedDisplay) {super(decoratedDisplay);}
    
    public void draw() {
        super.draw();       // 설정된 기존 표시 기능 수행
        drawLane();         // 추가적으로 차선 표시
    }
    
    private void drawLane() {
        System.out.println("\t차선 표시");
    }
    
}