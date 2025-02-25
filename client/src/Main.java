import static java.lang.Thread.sleep;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        Integer sequence = 1;

        while(true) {
            ClientTest clientTest = new ClientTest(sequence++);
            clientTest.start();
            try{
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}