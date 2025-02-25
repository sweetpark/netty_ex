public class ClientTest extends Thread{
    private Integer sequnce;

    public ClientTest(Integer sequence){
        this.sequnce = sequence;
    }
    @Override
    public void run() {
        Client client = new Client("127.0.0.1", 5555);
        int endCnt = 0;
        while(true){

            if(endCnt == 5){
                client.sendRequest("exit");
            }else{
                client.sendRequest("hi server! i'm client "+sequnce);
            }
            endCnt++;
            System.out.println(client.getRecvMessage());
        }
    }
}
